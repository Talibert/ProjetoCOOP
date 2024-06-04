package com.projetocoop.types;

public enum EspecializationType {

    FRONTEND("Front-End"),
    BACKEND("Back-End"),
    FULLSTACK("Full-Stack");

    private String area;

    EspecializationType(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
