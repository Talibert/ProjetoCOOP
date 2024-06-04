package com.projetocoop.types;

import java.util.ArrayList;
import java.util.List;

public enum CoursesType {

    JAVASCRIPT("Trilha JavaScript", EspecializationType.FRONTEND, Teacher.JEFFINHO, "Conjunto de cursos que abordam a tecnologia JS"),
    JAVA("Trilha JAVA", EspecializationType.BACKEND, Teacher.TALIBA, "Conjunto de cursos que abordam a tecnologia JAVA"),
    REACT("Trilha ReactJS", EspecializationType.FRONTEND, Teacher.PONTIFICI,"Conjunto de cursos que abordam a tecnologia ReactJS"),
    SPRINGBOOT("Trilha JAVA com Spring para aplicações Web", EspecializationType.FULLSTACK, Teacher.TALIBA, "Conjunto de cursos que abordam a tecnologia JAVA com o uso de Spring");

    private String trail;
    private EspecializationType especializationType;
    private Teacher teacher;
    private String description;

    CoursesType(String trail, EspecializationType especializationType, Teacher teacher, String description){
        this.trail = trail;
        this.especializationType = especializationType;
        this.teacher = teacher;
        this.description = description;
    }

    public String getTrail(){
        return trail;
    }

    public String getEspecializationType(){
        return especializationType.getArea();
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public String getDescription(){
        return description;
    }

    public static List<CoursesType> getAllCoursesType(){
        return List.of(CoursesType.JAVASCRIPT, CoursesType.JAVA, CoursesType.REACT, CoursesType.SPRINGBOOT);
    }
}
