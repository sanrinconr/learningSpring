package com.mercadolibre.consulting.exception.exception;

public class NotProfessionalServicePassedException extends Exception{
    public NotProfessionalServicePassedException() {
        super("A professional service is needed to be passed");
    }
}
