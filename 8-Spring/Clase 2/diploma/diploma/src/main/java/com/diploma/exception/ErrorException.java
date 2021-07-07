package com.diploma.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorException{
    private String error;

    public ErrorException(String error) {
        this.error = error;
    }
}
