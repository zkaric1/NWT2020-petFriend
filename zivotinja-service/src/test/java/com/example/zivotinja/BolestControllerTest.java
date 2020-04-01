package com.example.zivotinja;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BolestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @org.junit.jupiter.api.Test
    public void dobaviSveBolestiTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bolest")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))  // Velicina vracene liste da li je 3
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1))) // Da li prva bolest ima id 1
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ime", Matchers.is("Bjesnilo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ime", Matchers.is("Gripa")));
    }

    @org.junit.jupiter.api.Test
    public void dobaviJednuBolest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/bolesti/3")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lijek", Matchers.is("Injekcija")));
    }

    @org.junit.jupiter.api.Test
    public void obrisiPoId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/bolesti/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Ovaj i prethodni test se ne mogu pokrenuti istovremeno. Moze se ili sve obrisati ili pojedinacno
    /*
    @org.junit.jupiter.api.Test
    public void obrisiSveTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/bolesti")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @org.junit.jupiter.api.Test
    public void postTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bolesti")
                .param("ime", "Test")
                .param("lijek", "Antibiotici"));
    }

    @org.junit.jupiter.api.Test
    public void putTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/bolesti/{id}", 2)
                .content("ime=Test")
                .content("lijek=Antibiotici"));
    }
}
