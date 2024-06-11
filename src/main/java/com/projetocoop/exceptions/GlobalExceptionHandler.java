package com.projetocoop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Método para lidar com as exceções de matrículas não encontradas
     * @param enrollmentNotFoundException
     * @return
     */
    @ExceptionHandler(EnrollmentNotFoundException.class)
    public ResponseEntity<String> handleEnrollmentNotFoundException(EnrollmentNotFoundException enrollmentNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enrollmentNotFoundException.getMessage());
    }

    /**
     * Método para lidar com as exceções de matrículas não encontradas
     * @param studentNotFoundException
     * @return
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentNotFoundException.getMessage());
    }

    /**
     * Método para lidar com as exceções de matrículas não encontradas
     * @param courseNotFoundException
     * @return
     */
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(CourseNotFoundException courseNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(courseNotFoundException.getMessage());
    }

    /**
     * Método para lidar com as exceções de matrículas duplicadas
     * @param duplicateEnrollmenteException
     * @return
     */
    @ExceptionHandler(DuplicateEnrollmenteException.class)
    public ResponseEntity<String> handleDuplicateEnrollmentException(DuplicateEnrollmenteException duplicateEnrollmenteException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(duplicateEnrollmenteException.getMessage());
    }
}
