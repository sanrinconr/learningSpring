package com.starwars.exception.controller;

import com.starwars.exception.model.Error;
import com.starwars.exception.exceptions.ActorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptions {

    @ExceptionHandler(ActorNotFoundException.class)
    public ResponseEntity<Error> actorNotFound(ActorNotFoundException catched){
        Error err = new Error(catched.getClass().getName(), catched.getMessage());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> defaultException(Exception catched){
        Error err = new Error(catched.getClass().getName(), catched.getMessage());
        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
