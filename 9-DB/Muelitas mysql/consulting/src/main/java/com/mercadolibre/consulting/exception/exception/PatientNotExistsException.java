package com.mercadolibre.consulting.exception.exception;

public class PatientNotExistsException extends Exception{
    public PatientNotExistsException(String id) {
        super("Patient with id ("+id+") not exists");
    }
}
