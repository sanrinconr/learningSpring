package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.RunAtStart;
import com.mercadolibre.consulting.dataGenerators.patient.PatientGenerator;
import com.mercadolibre.consulting.enums.ProfessionalServices;
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
public class GetAllTurnsIntegrationTest {
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
    @DisplayName("Integration: Get all turns")
    public void createATurn() throws Exception {
        mockMvc.perform(get("/turn/getAll"))
                .andExpect(status().isOk());
    }
}
