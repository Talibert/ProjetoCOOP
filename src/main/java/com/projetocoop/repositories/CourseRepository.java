package com.projetocoop.repositories;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.types.CoursesType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCoursesType(CoursesType coursesType);

    List<Course> findByTeacher(String teacher);

    List<Course> findByEspecialization(String especialization);
}
