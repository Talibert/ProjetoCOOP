package com.projetocoop.service;

import com.projetocoop.dto.request.EnrollmentRequestDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.exceptions.EnrollmentNotFoundException;
import com.projetocoop.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    /**
     * Encontra uma matricula através do id recebido
     * @param id
     * @return
     */
    public Enrollment findById(Long id){
        Optional<Enrollment> enrollment = enrollmentRepository.findById(id);

        return enrollment.map(enrollmentResult -> enrollment.get() )
                .orElseThrow(() -> new EnrollmentNotFoundException("Matrícula de id: " + id + " não existe!"));
    }

    /**
     * Retorna uma lista de matrículas de acordo com os parâmetros recebidos
     * @return
     */
    public List<Enrollment> getEnrollmentList(Long studentId, Long courseId){
        List<Enrollment> enrollmentList;

        if (studentId != null) {
            enrollmentList = enrollmentRepository.findByStudentId(studentId);
        } else if (courseId != null) {
            enrollmentList = enrollmentRepository.findByCourseId(courseId);
        } else {
            enrollmentList = enrollmentRepository.findAll();
        }

        if (enrollmentList.isEmpty()){
            throw new EnrollmentNotFoundException("Nenhuma matrícula encontrada");
        }

        return enrollmentList;
    }

    /**
     * Atualiza uma matrícula existente
     * @param id
     * @param enrollmentRequestDTO
     * @return
     */
    public Enrollment updateEnrollment(Long id, EnrollmentRequestDTO enrollmentRequestDTO) {
        List<Enrollment> allEnrollment = enrollmentRepository.findAll();

        verifyIfEnrollmentExists(enrollmentRequestDTO, allEnrollment);

        Enrollment enrollment = findById(id);
        Student student = studentService.findById(enrollmentRequestDTO.getStudentId());
        Course course = courseService.findById(enrollmentRequestDTO.getCourseId());
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    /**
     * Cria uma nova matrícula
     * @param enrollmentRequestDTO
     * @return
     * @throws Exception
     */
    public Enrollment insertEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) {
        List<Enrollment> allEnrollment = enrollmentRepository.findAll();

        verifyIfEnrollmentExists(enrollmentRequestDTO, allEnrollment);

        Student student = studentService.findById(enrollmentRequestDTO.getStudentId());
        Course course = courseService.findById(enrollmentRequestDTO.getCourseId());
        Enrollment enrollment = new Enrollment(student, course);

        return enrollmentRepository.save(enrollment);
    }

    /**
     * Deleta uma matrícula através do id recebido.
     * @param id
     */
    public void deleteEnrollment(Long id){
        if(!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException("Matrícula de id: " + id + " não encontrada!");
        }
        enrollmentRepository.deleteById(id);
    }

    /**
     * Verifica se uma matrícula existe
     * @param enrollmentRequestDTO
     * @param allEnrollment
     */
    private void verifyIfEnrollmentExists(EnrollmentRequestDTO enrollmentRequestDTO, List<Enrollment> allEnrollment) {
        for(Enrollment enrollment : allEnrollment) {
            if(enrollmentRequestDTO.getStudentId() == enrollment.getStudent().getId()
                    && enrollmentRequestDTO.getCourseId() == enrollment.getCourse().getId()) {
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("A matrícula do estudante: ")
                        .append(enrollment.getStudent().getName())
                        .append(" para o curso: ")
                        .append(enrollment.getCourse().getName())
                        .append(" já existe!");

                throw new DuplicateEnrollmenteException(mensagem.toString());
            }
        }
    }

}
