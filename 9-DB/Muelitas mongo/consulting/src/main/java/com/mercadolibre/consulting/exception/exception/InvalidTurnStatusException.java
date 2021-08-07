package com.mercadolibre.consulting.exception.exception;

public class InvalidTurnStatusException extends Exception{
    public InvalidTurnStatusException(String badStatus) {
        super("The turn with status "+badStatus+" not exists");
    }
}
