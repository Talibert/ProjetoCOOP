package com.projetocoop.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message) {
        super(message);
    }
}
