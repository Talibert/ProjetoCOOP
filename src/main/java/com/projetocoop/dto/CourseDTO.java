package com.projetocoop.dto;

import com.projetocoop.types.CoursesType;

public class CourseDTO {

    private String name;

    private String description;

    private double duration;

    private CoursesType coursesType;

    public CourseDTO() {
    }

    public CourseDTO(String name, String description, double duration, CoursesType coursesType) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.coursesType = coursesType;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public CoursesType getCoursesType() {
        return coursesType;
    }

    public void setCoursesType(CoursesType coursesType) {
        this.coursesType = coursesType;
    }
}
