package com.projetocoop.service;

import com.projetocoop.dto.CourseRequestDTO;
import com.projetocoop.entities.Course;
import com.projetocoop.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Encontra um curso através do Id recebido
     * @param id
     * @return
     */
    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    /**
     * Retorna uma lista com todos os cursos
     * @return
     */
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    /**
     * Altera um curso existente
     * @param id
     * @param courseRequestDTO
     * @return
     */
    public Optional<Course> updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        return courseRepository.findById(id).map(course -> {
            if(courseRequestDTO.getName() != null){
                course.setName(courseRequestDTO.getName());
            }
            if(courseRequestDTO.getDescription() != null){
                course.setDescription(courseRequestDTO.getDescription());
            }
            if(courseRequestDTO.getDuration() != null){
                course.setDuration(courseRequestDTO.getDuration());
            }
            if(courseRequestDTO.getCoursesType() != null){
                course.setCoursesType(courseRequestDTO.getCoursesType());
                if(courseRequestDTO.getCoursesType().getTeacher() != null){
                    course.setTeacher(courseRequestDTO.getCoursesType().getTeacher().getName());
                }
                if(courseRequestDTO.getCoursesType().getEspecializationType() != null){
                    course.setEspecialization(courseRequestDTO.getCoursesType().getEspecializationType());
                }
            }
            return courseRepository.save(course);
        });
    }

    /**
     * Cria um novo curso
     * @param courseRequestDTO
     * @return
     */
    public Course insertCourse(CourseRequestDTO courseRequestDTO){
        Course course = new Course(courseRequestDTO);
        return courseRepository.save(course);
    }

    /**
     * Deleta um curso através do id recebido
     * @param id
     */
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
