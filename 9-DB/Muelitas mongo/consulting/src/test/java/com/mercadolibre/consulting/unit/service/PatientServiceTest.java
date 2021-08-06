package com.mercadolibre.consulting.unit.service;

import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.DTO.patient.response.PatientResponseDTO;
import com.mercadolibre.consulting.exception.exception.PatientNotExistsException;
import com.mercadolibre.consulting.model.PatientModel;
import com.mercadolibre.consulting.repository.PatientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.mercadolibre.consulting.service.PatientService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    ModelMapper modelMapper = new ModelMapper();
    @Mock
    PatientRepository patientRepository;
    PatientService patientService;

    @BeforeEach
    void initUseCase() {
        patientService = new PatientService(modelMapper,patientRepository);
    }


    @Test
    public void createPatient(){
        when(patientRepository.save(any(PatientModel.class))).thenReturn(new PatientModel());
        CreatePatientDTO entry = CreatePatientDTO.builder().name("Juan").last_name("Rojas").build();
        patientService.createNewPatient(entry);
    }

}
