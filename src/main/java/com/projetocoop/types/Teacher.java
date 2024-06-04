package com.projetocoop.types;

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
}
