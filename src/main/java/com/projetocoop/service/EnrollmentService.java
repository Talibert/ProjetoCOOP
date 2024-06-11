package com.projetocoop.service;

import com.projetocoop.dto.EnrollmentRequestDTO;
import com.projetocoop.dto.EnrollmentResponseDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.CourseNotFoundException;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.exceptions.EnrollmentNotFoundException;
import com.projetocoop.exceptions.StudentNotFoundException;
import com.projetocoop.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public EnrollmentResponseDTO findById(Long id){
        Optional<Enrollment> enrollmentResult = enrollmentRepository.findById(id);

        return enrollmentResult.map(EnrollmentResponseDTO::new)
                .orElseThrow(() -> new EnrollmentNotFoundException("Matrícula de id: " + id + " não encontrada!"));
    }

    /**
     * Retorna uma lista de matrículas
     * @return
     */
    public List<EnrollmentResponseDTO> getAllEnrollment(){
        return enrollmentRepository.findAll().stream().map(EnrollmentResponseDTO::new).toList();
    }

    /**
     * Atualiza uma matrícula existente
     * @param id
     * @param enrollmentRequestDTO
     * @return
     */
    public EnrollmentResponseDTO updateEnrollment(Long id, EnrollmentRequestDTO enrollmentRequestDTO) throws EnrollmentNotFoundException {
        Optional<Enrollment> enrollmentResult = enrollmentRepository.findById(id).map(enrollment -> {
            Optional<Student> student = studentService.findById(enrollmentRequestDTO.getStudentId());
            Optional<Course> course = courseService.findById(enrollmentRequestDTO.getCourseId());
            student.ifPresent(enrollment::setStudent);
            course.ifPresent(enrollment::setCourse);
            return enrollmentRepository.save(enrollment);
        });

        return enrollmentResult.map(EnrollmentResponseDTO::new)
                .orElseThrow(() -> new EnrollmentNotFoundException("Matrícula de id: " + id + " não encontrada!"));
    }

    /**
     * Cria uma nova matrícula
     * @param enrollmentRequestDTO
     * @return
     * @throws Exception
     */
    public EnrollmentResponseDTO insertEnrollment(EnrollmentRequestDTO enrollmentRequestDTO) throws Exception {
        List<EnrollmentResponseDTO> allEnrollment = getAllEnrollment();

        for(EnrollmentResponseDTO enrollmentResponseDTO : allEnrollment) {
            if(enrollmentRequestDTO.getStudentId() == enrollmentResponseDTO.getStudentId()
                    && enrollmentRequestDTO.getCourseId() == enrollmentResponseDTO.getCourseId()) {
                StringBuilder mensagem = new StringBuilder();
                mensagem.append("A matrícula do estudante: ")
                        .append(enrollmentResponseDTO.getStudentName())
                        .append(" para o curso: ")
                        .append(enrollmentResponseDTO.getCourseName())
                        .append(" já existe!");

                throw new DuplicateEnrollmenteException(mensagem.toString());
            }
        }

        Optional<Student> student = studentService.findById(enrollmentRequestDTO.getStudentId());

        if(student.isEmpty()){
            throw new StudentNotFoundException("O estudante de id: " + enrollmentRequestDTO.getStudentId() + " não existe");
        }

        Optional<Course> course = courseService.findById(enrollmentRequestDTO.getCourseId());

        if(course.isEmpty()){
            throw new CourseNotFoundException("O curso de id: " + enrollmentRequestDTO.getCourseId() + " não existe");
        }

        Enrollment enrollment = new Enrollment(student.get(), course.get());

        return new EnrollmentResponseDTO(enrollmentRepository.save(enrollment));
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

}
