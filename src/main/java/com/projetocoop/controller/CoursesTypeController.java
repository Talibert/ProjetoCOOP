package com.projetocoop.controller;

import com.projetocoop.dto.response.CoursesTypeResponseDTO;
import com.projetocoop.types.CoursesType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/courseType")
public class CoursesTypeController {

    /**
     * Retorna a lista com todos os courseTypes
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CoursesTypeResponseDTO>> getAllCoursesType(){
        List<CoursesTypeResponseDTO> coursesType = CoursesType.getAllCoursesType().stream().map(CoursesTypeResponseDTO::new).sorted().toList();
        return ResponseEntity.ok().body(coursesType);
    }
}
