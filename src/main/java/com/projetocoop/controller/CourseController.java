package com.projetocoop.controller;

import com.projetocoop.dto.CourseRequestDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * Encontra o curso pelo id
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseService.findById(id).map(course -> ResponseEntity.ok().body(course))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Retorna a lista com todos os cursos
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course> list = courseService.getAllCourses();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados do curso desejado
     * @param id
     * @param courseRequestDTO
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO){
        return courseService.updateCourse(id, courseRequestDTO).map(course -> ResponseEntity.ok().body(course))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo curso
     * @param courseRequestDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<Course> insert(@RequestBody CourseRequestDTO courseRequestDTO){
        Course course = courseService.insertCourse(courseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    /**
     * Deleta o curso
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
