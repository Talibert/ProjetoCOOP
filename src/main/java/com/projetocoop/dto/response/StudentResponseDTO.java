package com.projetocoop.dto.response;

import com.projetocoop.entities.Student;

import java.util.List;

public class StudentResponseDTO {

    private Long id;

    private String name;

    private String email;

    private List<EnrollmentResponseDTO> enrollmentResponseDTOList;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.enrollmentResponseDTOList = student.getEnrollmentList().stream().map(EnrollmentResponseDTO::new).toList();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<EnrollmentResponseDTO> getEnrollmentResponseDTOList() {
        return enrollmentResponseDTOList;
    }

    public void addEnrollmentResponseDTOList(EnrollmentResponseDTO enrollmentResponseDTO) {
        this.enrollmentResponseDTOList.add(enrollmentResponseDTO);
    }
}
