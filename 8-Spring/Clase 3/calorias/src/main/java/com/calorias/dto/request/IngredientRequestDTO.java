package com.calorias.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class IngredientRequestDTO {
    @NotNull(message = "Name of ingredient is needed")
    private String name;
    @NotNull(message = "Quantity of ingredient is needed")
    private double weight;
}
