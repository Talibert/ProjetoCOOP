package com.projetocoop;

import com.projetocoop.types.CoursesType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		String trilha = CoursesType.JAVA.getTrail();

		System.out.println(trilha);

		System.out.println(CoursesType.getAllCoursesType());
	}


}
