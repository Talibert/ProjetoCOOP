package com.projetocoop.entities;

import com.projetocoop.dto.CourseRequestDTO;
import com.projetocoop.types.CoursesType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

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
    private Double duration;

    @NotNull
    @Column
    private CoursesType coursesType;

    private String teacher;

    private String especialization;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollmentList;

    public Course(){
    }

    public Course(String name, String description, Double duration, CoursesType coursesType) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.coursesType = coursesType;
        this.teacher = this.coursesType.getTeacher().getName();
        this.especialization = this.coursesType.getEspecializationType();
        this.enrollmentList = new ArrayList<>();
    }

    public Course(CourseRequestDTO courseRequestDTO){
        this.name = courseRequestDTO.getName();
        this.description = courseRequestDTO.getDescription();
        this.duration = courseRequestDTO.getDuration();
        this.coursesType = courseRequestDTO.getCoursesType();
        this.teacher = this.coursesType.getTeacher().getName();
        this.especialization = this.coursesType.getEspecializationType();
        this.enrollmentList = new ArrayList<>();
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

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String getTeacher(){
        return teacher;
    }

    public void setEspecialization(String especialization){
        this.especialization = especialization;
    }

    public String getEspecialization(){
        return especialization;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollmentList.add(enrollment);
    }

    public List<Enrollment> getEnrollmentList(){
        return enrollmentList;
    }

}
