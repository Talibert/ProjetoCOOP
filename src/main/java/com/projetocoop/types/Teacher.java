package com.projetocoop.types;

import java.util.List;

public enum Teacher {
    JEFFINHO("Jeffinho", "Professor especialista em JavaScript"),
    TALIBA("Taliba", "Professor especialista em JAVA"),
    PONTIFICI("Pontifici", "Professor especialista em ReactJS");

    private String name;
    private String description;

    Teacher(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<Teacher> getAllTeacher(){
        return List.of(Teacher.TALIBA, Teacher.PONTIFICI, Teacher.JEFFINHO);
    }
}
