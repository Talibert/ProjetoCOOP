package com.projetocoop.dto.response;

import com.projetocoop.entities.Enrollment;

/**
 * Classe DTO responsável por encapsular objetos que serão enviados como resposta da classe Enrollment
 */
public class EnrollmentResponseDTO {

    private Long id;

    private Long studentId;

    private Long courseId;

    private String studentName;

    private String courseName;

    private String courseDescription;

    public EnrollmentResponseDTO() {
    }

    public EnrollmentResponseDTO(Enrollment enrollment){
        this.id = enrollment.getId();
        this.studentId = enrollment.getStudent().getId();
        this.courseId = enrollment.getCourse().getId();
        this.studentName = enrollment.getStudent().getName();
        this.courseName = enrollment.getCourse().getName();
        this.courseDescription = enrollment.getCourse().getDescription();
    }

    public Long getId() {
        return this.id;
    }

    public Long getStudentId(){
        return this.studentId;
    }

    public Long getCourseId(){
        return this.courseId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}
