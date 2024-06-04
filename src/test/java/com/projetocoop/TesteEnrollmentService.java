package com.projetocoop;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.service.EnrollmentService;
import com.projetocoop.service.StudentService;
import com.projetocoop.types.CoursesType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TesteEnrollmentService {


    private EnrollmentService enrollmentServiceSpy;
    private Student studentMock;
    private List<Enrollment> enrollmentList;

    @BeforeEach
    public void init(){
        enrollmentServiceSpy = Mockito.spy(new EnrollmentService());
        studentMock = Mockito.mock(Student.class);
        enrollmentList = new ArrayList<>();
    }

//    @Test
//    public void testeCreateNewEnrollmentError() throws DuplicateEnrollmenteException {
//        Course course = new Course("Curso teste", "Descrição teste", 1.0, CoursesType.JAVA);
//        Enrollment enrollment = new Enrollment(studentMock, course);
//        enrollmentList.add(enrollment);
//
//        Mockito.when(studentMock.getEnrollmentList()).thenReturn(enrollmentList);
//
//        String result = enrollmentServiceSpy.createNewEnrollment(studentMock, course);
//
//        assertEquals("O usuário já está matriculado no curso: Curso teste", result);
//    }
//
//    @Test
//    public void testeCreateNewEnrollmentSuccess() throws DuplicateEnrollmenteException {
//        Course course = new Course("Curso teste", "Descrição teste", 1.0, CoursesType.JAVA);
//        Course course2 = new Course("Curso teste 2", "Descrição teste", 1.0, CoursesType.JAVA);
//        Enrollment enrollment = new Enrollment(studentMock, course);
//        enrollmentList.add(enrollment);
//
//        Mockito.when(studentMock.getEnrollmentList()).thenReturn(enrollmentList);
//
//        String result = enrollmentServiceSpy.createNewEnrollment(studentMock, course2);
//
//        assertEquals("O usuário foi matrículado no curso: Curso teste 2", result);
//    }
}
