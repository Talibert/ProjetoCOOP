package com.projetocoop.exceptions;

public class EnrollmentNotFoundException extends RuntimeException{
    public EnrollmentNotFoundException(String message) {
        super(message);
    }
}
