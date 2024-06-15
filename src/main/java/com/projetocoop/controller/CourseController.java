package com.projetocoop.controller;

import com.projetocoop.dto.request.CourseRequestDTO;
import com.projetocoop.dto.response.CourseResponseDTO;
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
    public ResponseEntity<CourseResponseDTO> findById(@PathVariable Long id){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO(courseService.findById(id));
        return ResponseEntity.ok().body(courseResponseDTO);
    }

    /**
     * Retorna a lista com todos os cursos
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getCoursesList(
            @RequestParam(value = "coursesType", required = false) String coursesType,
            @RequestParam(value = "teacher", required = false) String teacher,
            @RequestParam(value = "especialization", required = false) String especialization){
        List<CourseResponseDTO> list = courseService.getCourseList(coursesType, teacher, especialization).stream().map(CourseResponseDTO::new).toList();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Altera os dados do curso desejado
     * @param id
     * @param courseRequestDTO
     * @return
     */
    @PutMapping (value = "/{id}")
    public ResponseEntity<CourseResponseDTO> update(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO(courseService.updateCourse(id, courseRequestDTO));
        return ResponseEntity.ok().body(courseResponseDTO);
    }

    /**
     * Cria um novo curso
     * @param courseRequestDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<CourseResponseDTO> insert(@RequestBody CourseRequestDTO courseRequestDTO){
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO(courseService.insertCourse(courseRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponseDTO);
    }

    /**
     * Deleta o curso
     * @param id
     * @return
     */
    @DeleteMapping (value ="/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
