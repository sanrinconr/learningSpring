package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.model.ErrorAttributesExceptionModel;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDefaultExceptionModel> badBody(){
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("Bad body","Check the body, empty or unexpected body has been passed"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDefaultExceptionModel> defaultException (Exception  e){
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("An error ocurred","Please try again, or contact the administrator"), HttpStatus.OK);
    }
}
