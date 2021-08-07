package com.mercadolibre.consulting.exception.advice;

import com.mercadolibre.consulting.exception.exception.InvalidTurnStatusException;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TurnControllerAdvice {
    @ExceptionHandler(InvalidTurnStatusException.class)
    public ResponseEntity<ErrorDefaultExceptionModel> invalidTurn(InvalidTurnStatusException e){
        return new ResponseEntity<>(new ErrorDefaultExceptionModel("Invalid status",e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
