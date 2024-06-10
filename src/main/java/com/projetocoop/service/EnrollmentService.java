package com.projetocoop.service;

import com.projetocoop.dto.CourseDTO;
import com.projetocoop.dto.EnrollmentDTO;
import com.projetocoop.dto.StudentDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.repositories.CourseRepository;
import com.projetocoop.repositories.EnrollmentRepository;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Optional<Enrollment> findById(Long id){
        return enrollmentRepository.findById(id);
    }

    /**
     * Retorna uma lista de matrículas
     * @return
     */
    public List<Enrollment> getAllEnrollment(){
        return enrollmentRepository.findAll();
    }

    /**
     * Atualiza uma matrícula existente
     * @param id
     * @param enrollmentDTO
     * @return
     */
    public Optional<Enrollment> updateEnrollment(Long id, EnrollmentDTO enrollmentDTO) {
        return enrollmentRepository.findById(id).map(enrollment -> {
            Optional<Student> student = studentService.findById(enrollmentDTO.getStudentId());
            Optional<Course> course = courseService.findById(enrollmentDTO.getCourseId());
            student.ifPresent(enrollment::setStudent);
            course.ifPresent(enrollment::setCourse);
            return enrollmentRepository.save(enrollment);
        });
    }

    /**
     * Cria uma nova matrícula
     * @param enrollmentDTO
     * @return
     * @throws Exception
     */
    public Enrollment insertEnrollment(EnrollmentDTO enrollmentDTO) throws Exception {
        Optional<Student> student = studentService.findById(enrollmentDTO.getStudentId());

        if(student.isEmpty()){
            throw new Exception("O estudante não existe");
        }

        Optional<Course> course = courseService.findById(enrollmentDTO.getCourseId());

        if(course.isEmpty()){
            throw new Exception("O curso não existe");
        }

        Enrollment enrollment = new Enrollment(student.get(), course.get());

        return enrollmentRepository.save(enrollment);
    }

    /**
     * Deleta uma matrícula através do id recebido.
     * @param id
     */
    public void deleteEnrollment(Long id){
        enrollmentRepository.deleteById(id);
    }

}
