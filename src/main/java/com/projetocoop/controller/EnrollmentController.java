package com.projetocoop.controller;

import com.projetocoop.dto.CourseDTO;
import com.projetocoop.dto.EnrollmentDTO;
import com.projetocoop.dto.StudentDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.repositories.CourseRepository;
import com.projetocoop.repositories.EnrollmentRepository;
import com.projetocoop.service.CourseService;
import com.projetocoop.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    /**
     * Encontra a matrícula pelo id
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Enrollment> findById(@PathVariable Long id){
        return enrollmentService.findById(id).map(enrollment -> ResponseEntity.ok().body(enrollment))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retorna a lista com todos as matrículas
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollment(){
        List<Enrollment> list = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados da matrícula desejada
     * @param id
     * @param enrollmentDTO
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable Long id, @RequestBody EnrollmentDTO enrollmentDTO){
        return enrollmentService.updateEnrollment(id, enrollmentDTO).map(enrollment -> ResponseEntity.ok().body(enrollment))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova matrícula
     * @param enrollmentDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody EnrollmentDTO enrollmentDTO){
        Enrollment enrollment = null;

        try {
            enrollment = enrollmentService.insertEnrollment(enrollmentDTO);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    /**
     * Deleta a matrícula
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<Enrollment> delete(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
