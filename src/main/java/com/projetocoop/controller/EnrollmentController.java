package com.projetocoop.controller;

import com.projetocoop.dto.EnrollmentRequestDTO;
import com.projetocoop.dto.EnrollmentResponseDTO;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.exceptions.EnrollmentNotFoundException;
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
    public ResponseEntity<EnrollmentResponseDTO> findById(@PathVariable Long id){
        EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.findById(id);
        return ResponseEntity.ok().body(enrollmentResponseDTO);
    }

    /**
     * Retorna a lista com todos as matrículas
     * @return
     */
    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollment(){
        List<EnrollmentResponseDTO> list = enrollmentService.getAllEnrollment();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados da matrícula desejada
     * @param id
     * @param enrollmentRequestDTO
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<EnrollmentResponseDTO> update(@PathVariable Long id, @RequestBody EnrollmentRequestDTO enrollmentRequestDTO) {
        EnrollmentResponseDTO enrollmentResponseDTO = enrollmentService.updateEnrollment(id, enrollmentRequestDTO);
        return ResponseEntity.ok().body(enrollmentResponseDTO);
    }

    /**
     * Cria uma nova matrícula
     * @param enrollmentRequestDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody EnrollmentRequestDTO enrollmentRequestDTO){
        EnrollmentResponseDTO enrollment = null;

        try {
            enrollment = enrollmentService.insertEnrollment(enrollmentRequestDTO);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(enrollment);
    }

    /**
     * Deleta a matrícula
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.ok().body("Matrícula de id: " + id + " deletada com sucesso!");
    }
}
