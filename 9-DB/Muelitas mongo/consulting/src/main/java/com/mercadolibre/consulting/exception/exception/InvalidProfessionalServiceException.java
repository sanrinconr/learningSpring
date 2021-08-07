package com.mercadolibre.consulting.exception.exception;

public class InvalidProfessionalServiceException extends Exception{
    public InvalidProfessionalServiceException(String servicePassed) {
        super("The service "+servicePassed+" not is valid");
    }
}
