package com.projetocoop;

import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.service.EnrollmentService;
import com.projetocoop.types.CoursesType;
import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;

import java.util.List;

public class Testes {
    public static void main(String[] args) {
        Student guilherme = new Student("Guilherme", "guilhermetaliberti@gmail.com");

        Course javaBasics = new Course("JAVA Fundamentos", "Curso sobre os fundamentos básicos de JAVA", 4.00, CoursesType.JAVA);
        Course javaOO = new Course("JAVA Orientação a objetos", "Curso orientações a objetos no JAVA", 8.00, CoursesType.JAVA);
        Course javaData = new Course("JAVA Estrutura de dados", "Curso sobre as estruturas de dados do JAVA", 6.00, CoursesType.JAVA);

        EnrollmentService enrollmentService = new EnrollmentService();

        try{
            enrollmentService.createNewEnrollment(guilherme, javaData);
            enrollmentService.createNewEnrollment(guilherme, javaOO);
            enrollmentService.createNewEnrollment(guilherme, javaBasics);
            enrollmentService.createNewEnrollment(guilherme, javaBasics);
        } catch (DuplicateEnrollmenteException e) {
            System.out.println(e.getMessage());
        }


        List<Enrollment> enrollmentList = guilherme.getEnrollmentList();

        for(Enrollment enrollment : enrollmentList) {
            System.out.println(enrollment.getCourse().getName());
        }
    }
}
