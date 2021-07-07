package com.diploma.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Normalized;

import javax.validation.constraints.NotNull;

@Setter @Getter
public class AssignRequestDTO {
    @NotNull(message = "The assing dont have name")
    private String name;
    @NotNull(message = "The assign dont have qualification")
    private double qualification;
}
