package com.calorias.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Error {
    private String name;
    private String description;

    public Error(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
