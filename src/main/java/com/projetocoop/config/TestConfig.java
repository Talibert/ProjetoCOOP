package com.projetocoop.config;

import com.projetocoop.entities.Student;
import com.projetocoop.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


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

        Student testStudent = new Student("Guilherme", "guilhermetaliberti@gmail.com");
        studentRepository.save(testStudent);
    }
}
