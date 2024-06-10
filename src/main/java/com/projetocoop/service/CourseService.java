package com.projetocoop.service;

import com.projetocoop.dto.CourseDTO;
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
     * @param courseDTO
     * @return
     */
    public Optional<Course> updateCourse(Long id, CourseDTO courseDTO) {
        return courseRepository.findById(id).map(course -> {
            if(courseDTO.getName() != null){
                course.setName(courseDTO.getName());
            }
            if(courseDTO.getDescription() != null){
                course.setDescription(courseDTO.getDescription());
            }
            if(courseDTO.getDuration() != null){
                course.setDuration(courseDTO.getDuration());
            }
            if(courseDTO.getCoursesType() != null){
                course.setCoursesType(courseDTO.getCoursesType());
                if(courseDTO.getCoursesType().getTeacher() != null){
                    course.setTeacher(courseDTO.getCoursesType().getTeacher().getName());
                }
                if(courseDTO.getCoursesType().getEspecializationType() != null){
                    course.setEspecialization(courseDTO.getCoursesType().getEspecializationType());
                }
            }
            return courseRepository.save(course);
        });
    }

    /**
     * Cria um novo curso
     * @param courseDTO
     * @return
     */
    public Course insertCourse(CourseDTO courseDTO){
        Course course = new Course(courseDTO);
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
