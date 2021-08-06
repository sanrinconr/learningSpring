package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.DTO.patient.response.PatientResponseDTO;
import com.mercadolibre.consulting.exception.model.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetPatientByIdIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration: Obtain a patient")
    public void getAPatient() throws Exception {
        //Get that patient
        PatientResponseDTO expected = PatientResponseDTO.builder().name("Ana").last_name("Quevedo").build();
        String responseDTO = mockMvc.perform(get("/patient/1"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected), responseDTO);
    }

    @Test
    @DisplayName("Integration: Obtain a patient")
    public void getUnknownPatient() throws Exception {
        //Get that patient
        ExceptionMessage expected = new ExceptionMessage("Patient not exists","Patient with id (9999) not exists");
        String responseDTO = mockMvc.perform(get("/patient/9999"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected), responseDTO);
    }
}
