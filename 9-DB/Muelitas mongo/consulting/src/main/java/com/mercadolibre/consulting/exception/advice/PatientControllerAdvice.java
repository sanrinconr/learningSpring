package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PatientControllerAdvice {
    @ExceptionHandler(PatientNotExistsException.class)
    public ResponseEntity<ErrorDefaultExceptionModel> patientNotExists(PatientNotExistsException e){
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("Patient not exists", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
