package com.projetocoop.service;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentService {

    public void createNewEnrollment(Student student, Course course) throws DuplicateEnrollmenteException {
        List<Enrollment> enrollmentList = student.getEnrollmentList();

        for(Enrollment enrollment : enrollmentList){
            if(enrollment.getCourse().getName() == course.getName()){
                throw new DuplicateEnrollmenteException("O usuário já está matriculado no curso: " + course.getName());
            };
        }

        Enrollment enrollment = new Enrollment(student, course);
    }

}
