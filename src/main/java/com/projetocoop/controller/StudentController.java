package com.projetocoop.controller;

import com.projetocoop.dto.request.StudentRequestDTO;
import com.projetocoop.dto.response.StudentResponseDTO;
import com.projetocoop.entities.Student;
import com.projetocoop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Encontra o estudante pelo id
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Long id){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(studentService.findById(id));
        return ResponseEntity.ok().body(studentResponseDTO);
    }

    /**
     * Retorna a lista com todos os estudantes
     * @return
     */
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(){
        List<StudentResponseDTO> list = studentService.getAllStudents().stream().map(StudentResponseDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados do estudante desejado
     * @param id
     * @param studentRequestDTO
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(studentService.updateStudent(id, studentRequestDTO));
        return ResponseEntity.ok().body(studentResponseDTO);
    }

    /**
     * Cria um novo estudante
     * @param studentRequestDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<StudentResponseDTO> insert(@RequestBody StudentRequestDTO studentRequestDTO){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(studentService.insertStudent(studentRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponseDTO);
    }

    /**
     * Deleta o estudante
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
