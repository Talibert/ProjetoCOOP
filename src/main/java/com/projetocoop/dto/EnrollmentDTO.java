package com.projetocoop.dto;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Student;

public class EnrollmentDTO {

    private Long studentId;

    private Long courseId;

    public EnrollmentDTO() {
    }

    public EnrollmentDTO(Long student, Long courseId) {
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
