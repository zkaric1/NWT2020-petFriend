package com.example.zivotinja;

import com.example.zivotinja.repository.AnketaRepository;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnketaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private AnketaRepository anketaRepository;

    @org.junit.jupiter.api.Test
    public void dobaviSveAnkete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ankete")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].zivotinjaID.id", Matchers.is(1)));
    }

    @org.junit.jupiter.api.Test
    public void dobaviSveAnketeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ankete")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].zivotinjaID.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].zivotinjaID.ime", Matchers.is("Mini")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].zivotinjaID.spol", Matchers.is("Z")));
    }

    @org.junit.jupiter.api.Test
    public void dobaviAnketuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ankete/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zivotinjaID.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zivotinjaID.ime", Matchers.is("Mini")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zivotinjaID.spol", Matchers.is("Z")));
    }
}
