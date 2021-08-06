package com.mercadolibre.consulting.exception.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ErrorAttributesExceptionModel {
    private final String description;
    private final Map<String, String> fieldErrors;

    public ErrorAttributesExceptionModel(String description) {
        this.description = description;
        fieldErrors = new HashMap<>();
    }

    public void addFieldError(String name, String message) {
        fieldErrors.put(name, message);
    }
}
