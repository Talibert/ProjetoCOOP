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

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> updateCourse(Long id, CourseDTO courseDTO) {
        return courseRepository.findById(id).map(course -> {
            course.setName(courseDTO.getName());
            course.setDescription(courseDTO.getDescription());
            course.setDuration(courseDTO.getDuration());
            course.setCoursesType(courseDTO.getCoursesType());
            return courseRepository.save(course);
        });
    }

    public Course insertCourse(CourseDTO courseDTO){
        Course course = new Course(courseDTO);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
