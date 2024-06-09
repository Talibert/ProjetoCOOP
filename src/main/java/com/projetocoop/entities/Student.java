package com.projetocoop.entities;

import com.projetocoop.dto.StudentDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollmentList;

    public Student(){

    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
        this.enrollmentList = new ArrayList<>();
    }

    public Student(StudentDTO studentDTO){
        this.name = studentDTO.getName();
        this.email = studentDTO.getEmail();
        this.enrollmentList = new ArrayList<>();
    }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void addEnrolment(Enrollment enrollment) {
        this.enrollmentList.add(enrollment);
    }

}
