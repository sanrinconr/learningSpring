package com.mercadolibre.consulting.DTO.professional.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessionalInTurnResponseDTO {
    private String name;
    private String last_name;
    private String service;
}
