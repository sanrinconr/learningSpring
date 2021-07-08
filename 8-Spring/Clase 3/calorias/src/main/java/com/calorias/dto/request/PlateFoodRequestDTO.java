package com.calorias.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
public class PlateFoodRequestDTO {

    @NotNull(message = "Name of plate is needed")
    private String name;
    @NotNull(message = "ingredients of the plate is needed")
    @Valid
    private List<IngredientRequestDTO> ingredientRequestDTOList;
}
