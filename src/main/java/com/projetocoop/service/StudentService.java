package com.projetocoop.service;

import com.projetocoop.dto.request.StudentRequestDTO;
import com.projetocoop.dto.response.StudentResponseDTO;
import com.projetocoop.entities.Student;
import com.projetocoop.exceptions.StudentNotFoundException;
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
    public Student findById(Long id){

        Optional<Student> student= studentRepository.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("O estudante de id: " + id + " não existe!");
        }

        return student.get();
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
    public Student updateStudent(Long id, StudentRequestDTO studentDTO) {
        Student student = findById(id);
        if(studentDTO.getName() != null){
            student.setName(studentDTO.getName());
        }
        if(studentDTO.getEmail() != null){
            student.setEmail(studentDTO.getEmail());
        }

        return studentRepository.save(student);
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
