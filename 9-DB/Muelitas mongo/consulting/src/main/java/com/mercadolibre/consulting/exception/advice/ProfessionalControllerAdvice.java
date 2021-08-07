package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.exception.InvalidProfessionalServiceException;
import com.mercadolibre.consulting.exception.exception.NoProfessionalFoundException;
import com.mercadolibre.consulting.exception.exception.NotProfessionalServicePassedException;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import com.mercadolibre.consulting.exception.model.ErrorServiceExceptionModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ProfessionalControllerAdvice {
    @ExceptionHandler(NoProfessionalFoundException.class)
    public ResponseEntity<ErrorDefaultExceptionModel> noProfessional(NoProfessionalFoundException e){
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("No professional found", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidProfessionalServiceException.class)
    public ResponseEntity<ErrorServiceExceptionModel> serviceNotExists(InvalidProfessionalServiceException e){
        return new ResponseEntity<>(new ErrorServiceExceptionModel(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotProfessionalServicePassedException.class)
    public ResponseEntity<ErrorServiceExceptionModel> notServicePassed(NotProfessionalServicePassedException e){
        return new ResponseEntity<>(new ErrorServiceExceptionModel("No service passed", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
