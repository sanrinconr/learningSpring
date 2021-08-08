package com.mercadolibre.consulting.controller;

import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
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

}
