package com.projetocoop.controller;

import com.projetocoop.entities.Student;
import com.projetocoop.repositories.StudentRepository;
import com.projetocoop.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (value = "/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

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
     * Altera os dados do estudante desejado
     * @param id
     * @param updatedStudent
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student updatedStudent){
        return studentService.updateStudent(id, updatedStudent).map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo estudante
     * @param newStudent
     * @return
     */
    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student newStudent){
        Student student = studentService.insertStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    /**
     * Deleta o estudante
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
