package com.projetocoop.dto.response;

import com.projetocoop.entities.Course;
import com.projetocoop.types.CoursesType;

public class CoursesTypeResponseDTO {

    private String name;

    private String trail;

    private String especialization;

    private String teacher;

    private String description;

    public CoursesTypeResponseDTO() {
    }

    public CoursesTypeResponseDTO(CoursesType coursesType){
        this.name = coursesType.name();
        this.trail = coursesType.getTrail();
        this.especialization = coursesType.getEspecializationType();
        this.teacher = coursesType.getTeacher().getName();
        this.description = coursesType.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    public String getEspecialization() {
        return especialization;
    }

    public void setEspecialization(String especialization) {
        this.especialization = especialization;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
