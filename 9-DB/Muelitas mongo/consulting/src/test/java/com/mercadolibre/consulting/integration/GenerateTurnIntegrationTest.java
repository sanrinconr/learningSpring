package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.RunAtStart;
import com.mercadolibre.consulting.dataGenerators.patient.PatientGenerator;
import com.mercadolibre.consulting.enums.ProfessionalServices;
import com.mercadolibre.consulting.exception.model.ErrorDefaultExceptionModel;
import com.mercadolibre.consulting.exception.model.ErrorServiceExceptionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GenerateTurnIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void clearDB(){
        RunAtStart.cleanDB();
        RunAtStart.insertTestData();
    }

    @Test
    @DisplayName("Integration: Create a turn")
    public void createATurn() throws Exception {
        CreatePatientDTO data = modelMapper.map(PatientGenerator.generateOne(), CreatePatientDTO.class);
        mockMvc.perform(get("/turn/generate/1")
                .param("service", ProfessionalServices.GENERAL.toString()))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Integration: Create a turn on patient that not exists")
    public void createATurnPatientNotExists() throws Exception {
        ErrorDefaultExceptionModel expected = new ErrorDefaultExceptionModel("Patient not exists","Patient with id (9876) not exists");
        CreatePatientDTO data = modelMapper.map(PatientGenerator.generateOne(), CreatePatientDTO.class);
        String response = mockMvc.perform(get("/turn/generate/9876")
                .param("service", ProfessionalServices.GENERAL.toString()))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected),response);
    }

    @Test
    @DisplayName("Integration: Create a turn with bad service")
    public void createATurnBadEntry() throws Exception {
        ErrorServiceExceptionModel expected = new ErrorServiceExceptionModel("The service BADSERVICE not is valid");
        CreatePatientDTO data = modelMapper.map(PatientGenerator.generateOne(), CreatePatientDTO.class);
        String response = mockMvc.perform(get("/turn/generate/1")
                .param("service", "BADSERVICE"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected),response);
    }

    @Test
    @DisplayName("Integration: Create a turn without service")
    public void createATurnWithoutService() throws Exception {
        ErrorServiceExceptionModel expected = new ErrorServiceExceptionModel("No service passed","A professional service is needed to be passed");
        CreatePatientDTO data = modelMapper.map(PatientGenerator.generateOne(), CreatePatientDTO.class);
        String response = mockMvc.perform(get("/turn/generate/1"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected),response);
    }

    @Test
    @DisplayName("Integration: Create a turn with a service that not have professionals")
    public void createATurnWithoutProfessionalService() throws Exception {
        ErrorDefaultExceptionModel expected = new ErrorDefaultExceptionModel("No professional found","No professionals for service: NOTUSED");
        CreatePatientDTO data = modelMapper.map(PatientGenerator.generateOne(), CreatePatientDTO.class);
        String response = mockMvc.perform(get("/turn/generate/1")
                .param("service",ProfessionalServices.NOTUSED.toString()))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected),response);
    }
}
