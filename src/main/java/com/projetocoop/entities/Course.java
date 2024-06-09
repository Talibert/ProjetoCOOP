package com.projetocoop.entities;

import com.projetocoop.dto.CourseDTO;
import com.projetocoop.types.CoursesType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String description;

    @NotNull
    @Column
    private double duration;

    @NotNull
    @Column
    private CoursesType coursesType;

    private String teacher;

    private String especialization;

    public Course(){
    }

    public Course(String name, String description, double duration, CoursesType coursesType) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.coursesType = coursesType;
        this.teacher = this.coursesType.getTeacher().getName();
        this.especialization = this.coursesType.getEspecializationType();
    }

    public Course(CourseDTO courseDTO){
        this.name = courseDTO.getName();
        this.description = courseDTO.getDescription();
        this.duration = courseDTO.getDuration();
        this.coursesType = courseDTO.getCoursesType();
        this.teacher = this.coursesType.getTeacher().getName();
        this.especialization = this.coursesType.getEspecializationType();
    }

    public long getId() { return id; }

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

    public String getTeacher(){
        return teacher;
    }

    public String getEspecialization(){
        return especialization;
    }
}
