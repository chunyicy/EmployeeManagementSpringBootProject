package com.myspringbootproject.employeeManagementBackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// set up a global exception handler using @ControllerAdvice or @RestControllerAdvice
// this annotation allows to centralize exception handling logic across all controllers

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // defines that this method handles ResourceNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){

        // set the HTTP status to 404 NOT FOUND
        // returns ResponseEntity with the exception message as the response body

        // constructs an HTTP 404 response with the exception message as the response body
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
