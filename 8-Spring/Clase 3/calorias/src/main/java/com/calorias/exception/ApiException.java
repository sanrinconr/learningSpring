package com.calorias.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.EscapedErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException {

    @ExceptionHandler(IngredientNotExistException.class)
    public ResponseEntity<Error> ingredientNotExists(IngredientNotExistException e){
        Error out = new Error(e.getName(), e.getDescription());
        return new ResponseEntity<>(out, HttpStatus.NOT_FOUND);
    }

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> defaultExeception(Exception e){
        e.printStackTrace();
        Error out = new Error(e.getClass().getName(), e.getMessage());
        return new ResponseEntity<>(out, HttpStatus.NOT_FOUND);
    }
}
