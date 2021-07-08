package com.calorias.dto.response;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class PlateCaloriesResponseDTO {
    private String name;
    private int calories;
}
