package com.projetocoop.controller;

import com.projetocoop.dto.StudentRequestDTO;
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
    public ResponseEntity<Student> findById(@PathVariable Long id){
        return studentService.findById(id).map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retorna a lista com todos os estudantes
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentService.getAllStudents();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados do estudante desejado
     * @param id
     * @param studentDTO
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentRequestDTO studentDTO){
        return studentService.updateStudent(id, studentDTO).map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo estudante
     * @param studentDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody StudentRequestDTO studentDTO){
        Student student = studentService.insertStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    /**
     * Deleta o estudante
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
