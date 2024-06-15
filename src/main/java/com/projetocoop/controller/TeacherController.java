package com.projetocoop.controller;

import com.projetocoop.dto.response.CoursesTypeResponseDTO;
import com.projetocoop.dto.response.TeacherResponseDTO;
import com.projetocoop.types.CoursesType;
import com.projetocoop.types.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/teacher")
public class TeacherController {

    /**
     * Retorna a lista com todos os courseTypes
     * @return
     */
    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> getAllCoursesType(){
        List<TeacherResponseDTO> teacherList = Teacher.getAllTeacher().stream().map(TeacherResponseDTO::new).sorted().toList();
        return ResponseEntity.ok().body(teacherList);
    }
}
