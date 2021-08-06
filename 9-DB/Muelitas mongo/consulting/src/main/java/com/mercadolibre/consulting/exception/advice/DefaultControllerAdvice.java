package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.exception.model.ErrorAttributesExceptionModel;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class DefaultControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorAttributesExceptionModel> argumentNotValid(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        ErrorAttributesExceptionModel errorAttributesExceptionModel = new ErrorAttributesExceptionModel("Error with a few attributes");
        fieldErrors.forEach(fieldError -> errorAttributesExceptionModel.addFieldError(fieldError.getField(), fieldError.getDefaultMessage()));
        return new ResponseEntity<>(errorAttributesExceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PatientNotExistsException.class)
    public ResponseEntity<ErrorDefaultExceptionModel> patientNotExists(PatientNotExistsException e){
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("Patient not exists", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
