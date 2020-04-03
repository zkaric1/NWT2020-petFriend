package com.etf.anketa_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProvidedAnswerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @org.junit.jupiter.api.Test
    public void getAllAnswers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/providedAnswer/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}
