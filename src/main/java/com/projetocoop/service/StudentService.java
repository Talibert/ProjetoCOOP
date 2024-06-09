package com.projetocoop.service;

import com.projetocoop.dto.StudentDTO;
import com.projetocoop.entities.Student;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            return studentRepository.save(student);
        });
    }

    public Student insertStudent(StudentDTO studentDTO){
        Student student = new Student(studentDTO);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
