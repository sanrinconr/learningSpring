package com.mercadolibre.consulting.DTO.patient.response;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponseDTO {
    private String name;
    private String last_name;
    private List<TurnResponseDTO> turns;
}
