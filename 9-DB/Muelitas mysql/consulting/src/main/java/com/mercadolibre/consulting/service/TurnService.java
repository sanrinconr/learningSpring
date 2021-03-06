package com.mercadolibre.consulting.service;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.model.TurnModel;
import com.mercadolibre.consulting.repository.TurnRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnService {
    private final ModelMapper modelMapper;
    private final TurnRepository turnRepository;

    public TurnService(ModelMapper modelMapper, TurnRepository turnRepository) {
        this.modelMapper = modelMapper;
        this.turnRepository = turnRepository;
    }

    public List<TurnResponseDTO> getProfessionalTurnsOfTheDay(String doctorId){
        List<TurnModel> models = turnRepository.findTurnsOfAProfessional((long) Integer.parseInt(doctorId));
        return models.stream().map((model->modelMapper.map(model, TurnResponseDTO.class))).collect(Collectors.toList());
    }
}
