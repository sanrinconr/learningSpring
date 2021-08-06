package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.exception.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler(PatientNotExistsException.class)
    public ResponseEntity<ExceptionMessage> patientNotExists(PatientNotExistsException e){
        return new ResponseEntity<>(new ExceptionMessage("Patient not exists", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
