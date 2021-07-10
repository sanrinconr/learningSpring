package com.linkTracker.exception.controller;

import com.linkTracker.exception.exception.LinkAlreadyExistsException;
import com.linkTracker.exception.exception.LinkNotExistException;
import com.linkTracker.exception.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException {
    //https://www.baeldung.com/spring-boot-bean-validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> missingAttributes(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LinkNotExistException.class)
    public ResponseEntity<ErrorModel> linkNotExists(LinkNotExistException ex){
        ErrorModel out = new ErrorModel("Link not exists",ex.getMessage());
        return new ResponseEntity<>(out, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(LinkAlreadyExistsException.class)
    public ResponseEntity<ErrorModel> linkAlreadyExists(LinkAlreadyExistsException ex){
        ErrorModel out = new ErrorModel("Link already exists",ex.getMessage());
        return new ResponseEntity<>(out, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorModel> notBodyProvided(Exception ex){
        ErrorModel out = new ErrorModel("Hubo un problema en el formato del body",ex.getMessage());
        return new ResponseEntity<>(out, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorModel> exceptionHandler(Exception ex){
        ex.printStackTrace();
        ErrorModel out = new ErrorModel("Error","We have a error, please try again later");
        return new ResponseEntity<>(out, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
