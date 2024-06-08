package com.projetocoop.service;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Student;
import com.projetocoop.repositories.CourseRepository;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

    public Optional<Course> updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setName(updatedCourse.getName());
            course.setDescription(updatedCourse.getDescription());
            course.setDuration(updatedCourse.getDuration());
            course.setCoursesType(updatedCourse.getCoursesType());
            return courseRepository.save(course);
        });
    }

    public Course insertCourse(Course newCourse){
        return courseRepository.save(newCourse);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
