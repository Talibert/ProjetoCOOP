package com.projetocoop.dto.response;

import com.projetocoop.entities.Course;
import com.projetocoop.types.CoursesType;

public class CourseResponseDTO {

    private Long id;

    private String name;

    private String description;

    private Double duration;

    private CoursesType coursesType;

    private String teacher;

    private String especialization;

    public CourseResponseDTO() {
    }

    public CourseResponseDTO(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
        this.duration = course.getDuration();
        this.coursesType = course.getCoursesType();
        this.teacher = course.getTeacher();
        this.especialization = course.getEspecialization();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public CoursesType getCoursesType() {
        return coursesType;
    }

    public void setCoursesType(CoursesType coursesType) {
        this.coursesType = coursesType;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getEspecialization() {
        return especialization;
    }

    public void setEspecialization(String especialization) {
        this.especialization = especialization;
    }
}
