package com.mercadolibre.consulting.exception.model;

import com.mercadolibre.consulting.enums.ProfessionalServices;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorServiceExceptionModel {
    private String name;
    private String description;
    private List<String> valid;

    public ErrorServiceExceptionModel(String description) {
        this.name = "Invalid service";
        this.description = description;
        this.valid = Arrays.stream(ProfessionalServices.class.getEnumConstants()).map(e->e.name()).collect(Collectors.toList());
    }
    public ErrorServiceExceptionModel(String name, String description) {
        this.name = name;
        this.description = description;
        this.valid = Arrays.stream(ProfessionalServices.class.getEnumConstants()).map(e->e.name()).collect(Collectors.toList());
    }
}
