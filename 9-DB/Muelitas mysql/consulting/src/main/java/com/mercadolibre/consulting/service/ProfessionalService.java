package com.mercadolibre.consulting.service;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.repository.ProfessionalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {
    private final ModelMapper modelMapper;
    private final ProfessionalRepository professionalRepository;

    public ProfessionalService(ModelMapper modelMapper, ProfessionalRepository professionalRepository) {
        this.modelMapper = modelMapper;
        this.professionalRepository = professionalRepository;
    }
}
