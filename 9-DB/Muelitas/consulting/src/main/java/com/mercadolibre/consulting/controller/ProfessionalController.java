package com.mercadolibre.consulting.controller;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.service.TurnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfessionalController {
    TurnService turnService;

    public ProfessionalController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping("/doctor/{id}/turns/day")
    public ResponseEntity<List<TurnResponseDTO>> getTurnsOfTheDay(@PathVariable String id){
        return new ResponseEntity<>(turnService.getProfessionalTurnsOfTheDay(id), HttpStatus.OK);
    }
}
