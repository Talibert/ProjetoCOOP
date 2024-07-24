package com.projetocoop.config;

import com.projetocoop.entities.Student;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;


/**
 * A interface CommandLineRunner força a implementação do método run.
 * Esse método será executado sempre que a aplicação rodar, como se fosse um método main.
 * Dessa forma, podemos instanciar os objetos sem necessariamente poluir o nosso método main
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("Guilherme", "guilhermetaliberti@gmail.com");
        Student student2 = new Student("Pontifici", "pontifici@yahoo.com");
        Student student3 = new Student("Jeffinho", "jeffinho@gmail.com");

        List<Student> students = List.of(student1, student2, student3);

        studentRepository.saveAll(students);
    }
}
