package com.mercadolibre.consulting.DTO.patient.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePatientDTO {
    @NotNull(message = "Name must be included")
    private String name;
    @NotNull(message = "Last name must be included")
    private String last_name;
}
