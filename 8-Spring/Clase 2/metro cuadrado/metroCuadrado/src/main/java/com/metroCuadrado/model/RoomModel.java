package com.metroCuadrado.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class RoomModel {
    @NotNull(message = "Room must have a name")
    private String name;
    @NotNull(message = "Room must have a width")
    private double width;
    @NotNull(message = "Room must have a large")
    private double large;
}
