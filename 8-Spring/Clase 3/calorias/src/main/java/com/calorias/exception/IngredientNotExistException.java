package com.calorias.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class IngredientNotExistException extends Exception {
    private String name;
    private String description;

    public IngredientNotExistException(String description) {
        this.name = "El ingrediente no existe";
        this.description = description;
    }
}
