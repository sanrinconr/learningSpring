package com.mercadolibre.consulting.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.consulting.DTO.turn.response.TurnResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GetTurnsOfTheDayProfessionalIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration: Get turns of a professional in the day")
    public void getAPatient() throws Exception {
        //Insert patient
        String response = mockMvc.perform(get("/doctor/1/turns/day"))
                .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();

        List<TurnResponseDTO> responseDTO = objectMapper.readValue(response, new TypeReference<List<TurnResponseDTO>>(){});
        Assertions.assertEquals("Diana",responseDTO.get(0).getProfessional().getName());
    }
}
