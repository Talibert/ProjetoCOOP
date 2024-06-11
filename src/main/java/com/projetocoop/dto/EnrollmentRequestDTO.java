package com.projetocoop.dto;

import com.projetocoop.entities.Enrollment;

/**
 * Classe DTO responsável por encapsular objetos que serão recebidos como parâmetro da classe Enrollment
 */
public class EnrollmentRequestDTO {

    private Long studentId;

    private Long courseId;

    public EnrollmentRequestDTO() {
    }

    public EnrollmentRequestDTO(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

}
