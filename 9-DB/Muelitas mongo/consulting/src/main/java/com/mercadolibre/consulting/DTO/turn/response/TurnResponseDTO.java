package com.mercadolibre.consulting.DTO.turn.response;

import com.mercadolibre.consulting.DTO.professional.response.ProfessionalInTurnResponseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TurnResponseDTO {
    private LocalDateTime f_entry;
    private LocalDateTime f_out;
    private String status;
    private ProfessionalInTurnResponseDTO professional;
}
