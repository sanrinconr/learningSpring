package com.mercadolibre.consulting.DTO.professional.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProfessionalInTurnResponseDTO {
    private String name;
    private String last_name;
    private String service;
}
