package com.mercadolibre.consulting.controller;

import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.DTO.patient.response.PatientResponseDTO;
import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/patient")
    public ResponseEntity<Void> createPatient(@Valid @RequestBody CreatePatientDTO createPatientDTO){
        patientService.createNewPatient(createPatientDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*@GetMapping("/patient/{id}/turn")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable String id) throws PatientNotExistsException {
        return new ResponseEntity<PatientResponseDTO>(patientService.getById((long) Integer.parseInt(id)),HttpStatus.OK);
    }*/
}
