package com.projetocoop.service;

import com.projetocoop.dto.request.CourseRequestDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.exceptions.CourseNotFoundException;
import com.projetocoop.repositories.CourseRepository;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseRequestDTO courseRequestDTO;

    @Mock
    private Course course;

    @Spy
    @InjectMocks
    private CourseService courseService;

    private AutoCloseable autoCloseable;

    @BeforeEach
    public void init(){
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void close() throws Exception {
        autoCloseable.close();
    }

    /**
     * Verifica se a chamada do repository irá acontecer.
     */
    @Test
    public void testeFindById(){
        Optional<Course> courseOptional = Optional.of(course);
        Long id = 1L;
        Course expected = courseOptional.get();
        Mockito.when(courseRepository.findById(id)).thenReturn(courseOptional);

        Course result = courseService.findById(id);

        assertEquals(expected, result);
        Mockito.verify(courseRepository, Mockito.times(1)).findById(id);
    }

    /**
     * Captura uma exception lançada por não encontrar o usuário e verifica se a mensagem está correta
     */
    @Test
    public void testeFindByIdException(){
        Optional<Course> courseOptional = Optional.empty();
        Long id = 1L;
        Mockito.when(courseRepository.findById(id)).thenReturn(courseOptional);
        String expectedMessage = "O curso de id: " + id + " não existe!";

        Exception exception = assertThrows(CourseNotFoundException.class, () -> {
            courseService.findById(id);
        });

        String resultMessage = exception.getMessage();

        assertEquals(expectedMessage, resultMessage);

        Mockito.verify(courseRepository, Mockito.times(1)).findById(id);
    }

    /**
     * Verifica se a chamada do repository filtrada pelo courseType irá acontecer.
     */
    @Test
    public void testeGetCourseListByCoursesType(){
        List<Course> expectedList = List.of(course);

        Mockito.when(courseRepository.findByCoursesType(Mockito.any())).thenReturn(expectedList);

        List<Course> resultList = courseService.getCourseList("JAVA", null, null);

        assertEquals(expectedList, resultList);

        Mockito.verify(courseRepository, Mockito.times(1)).findByCoursesType(Mockito.any());
    }

    /**
     * Verifica se a chamada do repository filtrada pelo teacher irá acontecer.
     */
    @Test
    public void testeGetCourseListByTeacher(){
        List<Course> expectedList = List.of(course);

        Mockito.when(courseRepository.findByTeacher(Mockito.any())).thenReturn(expectedList);

        List<Course> resultList = courseService.getCourseList(null, "Taliba", null);

        assertEquals(expectedList, resultList);

        Mockito.verify(courseRepository, Mockito.times(1)).findByTeacher(Mockito.any());
    }

    /**
     * Verifica se a chamada do repository filtrada pelo especialization irá acontecer.
     */
    @Test
    public void testeGetCourseListByEspecialization(){
        List<Course> expectedList = List.of(course);

        Mockito.when(courseRepository.findByEspecialization(Mockito.any())).thenReturn(expectedList);

        List<Course> resultList = courseService.getCourseList(null, null, "Back-End");

        assertEquals(expectedList, resultList);

        Mockito.verify(courseRepository, Mockito.times(1)).findByEspecialization(Mockito.any());
    }

    /**
     * Verifica se a chamada do repository sem filtros irá acontecer.
     */
    @Test
    public void testeGetCourseList(){
        List<Course> expectedList = List.of(course);

        Mockito.when(courseRepository.findAll()).thenReturn(expectedList);

        List<Course> resultList = courseService.getCourseList(null, null, null);

        assertEquals(expectedList, resultList);

        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
    }

    /**
     * Captura uma exception lançada por não encontrar nenhum curso e verifica se a mensagem está correta
     */
    @Test
    public void testeGetCourseListException(){
        List<Course> emptyList = new ArrayList<>();
        Mockito.when(courseRepository.findAll()).thenReturn(emptyList);
        String expectedMessage = "Nenhum curso encontrado";

        Exception exception = assertThrows(CourseNotFoundException.class, () -> {
            courseService.getCourseList(null, null, null);
        });

        String resultMessage = exception.getMessage();

        assertEquals(expectedMessage, resultMessage);

        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
    }
}