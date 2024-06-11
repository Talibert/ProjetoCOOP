package com.projetocoop.service;

import com.projetocoop.dto.StudentRequestDTO;
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

    /**
     * Encontra um estudante através do id recebido
     * @param id
     * @return
     */
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    /**
     * Retorna uma lista com todos os estudantes
     * @return
     */
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    /**
     * Atualiza um estudante existente
     * @param id
     * @param studentDTO
     * @return
     */
    public Optional<Student> updateStudent(Long id, StudentRequestDTO studentDTO) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            return studentRepository.save(student);
        });
    }

    /**
     * Cria um novo estudante
     * @param studentDTO
     * @return
     */
    public Student insertStudent(StudentRequestDTO studentDTO){
        Student student = new Student(studentDTO);
        return studentRepository.save(student);
    }

    /**
     * Deleta um estudante através do id recebido
     * @param id
     */
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
