package com.mercadolibre.consulting.controller;

import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import com.mercadolibre.consulting.exception.exception.*;
import com.mercadolibre.consulting.service.TurnService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TurnController {
    private final TurnService turnService;

    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping("/turn/generate/{patientId}")
    public ResponseEntity<TurnResponseDTO> generateTurn(@PathVariable String patientId, @RequestParam(required = false) String service) throws PatientNotExistsException, InvalidProfessionalServiceException, NoProfessionalFoundException, NotProfessionalServicePassedException {
        return new ResponseEntity<>(turnService.generateTurn(patientId, service), HttpStatus.OK);
    }

    @GetMapping("/turn/getAll")
    public ResponseEntity<List<TurnResponseDTO>> getAllTurns(@RequestParam(defaultValue = "PENDING") String status) throws InvalidTurnStatusException {
        return new ResponseEntity<>(turnService.getAllTurns(status), HttpStatus.OK);
    }

    @GetMapping("/turn/doctor")
    public ResponseEntity<List<TurnResponseDTO>> getAllTurnsOfADoctor(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String status) throws NoProfessionalFoundException, InvalidTurnStatusException {

        return new ResponseEntity<>(turnService.getAllTurnsOfADoctor(name, last_name, status), HttpStatus.OK);
    }
}
