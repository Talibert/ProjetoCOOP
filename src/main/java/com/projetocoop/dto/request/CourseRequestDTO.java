package com.projetocoop.dto.request;

import com.projetocoop.types.CoursesType;

public class CourseRequestDTO {

    private String name;

    private String description;

    private Double duration;

    private CoursesType coursesType;

    public CourseRequestDTO() {
    }

    public CourseRequestDTO(String name, String description, Double duration, CoursesType coursesType) {
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
}
