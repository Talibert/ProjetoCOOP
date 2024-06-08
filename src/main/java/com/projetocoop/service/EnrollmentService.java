package com.projetocoop.service;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.DuplicateEnrollmenteException;
import com.projetocoop.repositories.EnrollmentRepository;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Optional<Enrollment> findById(Long id){
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> getAllEnrollment(){
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> updateEnrollment(Long id, Enrollment updatedEnrollment) {
        return enrollmentRepository.findById(id).map(enrollment -> {
            enrollment.setStudent(updatedEnrollment.getStudent());
            enrollment.setCourse(updatedEnrollment.getCourse());
            return enrollmentRepository.save(enrollment);
        });
    }

    public Enrollment insertEnrollment(Enrollment newEnrollment){
        return enrollmentRepository.save(newEnrollment);
    }

    public void deleteEnrollment(Long id){
        enrollmentRepository.deleteById(id);
    }

}
