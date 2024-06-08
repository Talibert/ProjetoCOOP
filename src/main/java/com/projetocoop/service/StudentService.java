package com.projetocoop.service;

import com.projetocoop.entities.Course;
import com.projetocoop.entities.Enrollment;
import com.projetocoop.entities.Student;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllCourses(){
        return studentRepository.findAll();
    }

    public Optional<Student> updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            return studentRepository.save(student);
        });
    }

    public Student insertStudent(Student newStudent){
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
