package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.RunAtStart;
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
public class GetAllTurnsOfADoctor {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ModelMapper modelMapper;

    @BeforeEach
    public void clearDB() {
        RunAtStart.cleanDB();
        RunAtStart.insertTestData();
    }

    @Test
    @DisplayName("Integration: Get all turns of Diana Tazares")
    public void createATurn() throws Exception {
        mockMvc.perform(get("/turn/doctor")
                .param("name", "Diana")
                .param("last_name", "Tazares")
                .param("status", "PENDING"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration: Get all turns of Diana null")
    public void createATurnBadName() throws Exception {
        mockMvc.perform(get("/turn/doctor")
                .param("name", "Diana")
                .param("status", "PENDING"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Integration: Get all turns of Diana Tazares with bad status")
    public void createATurnBadStatus() throws Exception {
        mockMvc.perform(get("/turn/doctor")
                .param("name", "Diana")
                .param("status", "BADSTATUS"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Integration: Get all turns of Diana Tazares without status")
    public void createATurnWithNoStatus() throws Exception {
        mockMvc.perform(get("/turn/doctor")
                .param("name", "Diana"))
                .andExpect(status().isBadRequest());
    }
}
