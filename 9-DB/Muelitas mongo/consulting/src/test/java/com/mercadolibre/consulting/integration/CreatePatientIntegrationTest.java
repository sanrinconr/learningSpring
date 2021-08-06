package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.ConsultingApplication;
import com.mercadolibre.consulting.DTO.patient.request.CreatePatientDTO;
import com.mercadolibre.consulting.RunAtStart;
import com.mercadolibre.consulting.exception.model.ErrorAttributesExceptionModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CreatePatientIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void clearDB(){
        RunAtStart.cleanDB();
    }
    @Test
    @DisplayName("Integration: Create a patient")
    public void createAPatient() throws Exception {
        CreatePatientDTO data = CreatePatientDTO.builder().dni("100").name("Juan").last_name("Carlos").build();
        mockMvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration: Create a patient without DNI")
    public void createAPatientFail() throws Exception {
        ErrorAttributesExceptionModel expected = new ErrorAttributesExceptionModel("Error with a few attributes");
        expected.addFieldError("dni","Name must be included");
        CreatePatientDTO data = CreatePatientDTO.builder().name("Juan").last_name("Carlos").build();
        String response = mockMvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(objectMapper.writeValueAsString(expected), response);
    }
}
