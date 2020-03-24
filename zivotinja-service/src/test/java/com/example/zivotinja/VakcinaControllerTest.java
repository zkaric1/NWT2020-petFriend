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
public class VakcinaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @org.junit.jupiter.api.Test
    public void dobaviSveVakcineTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vakcine")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].tip", Matchers.is("Hepatits")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].revakcinacija", Matchers.is(24)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].tip", Matchers.is("Bolest")));
    }

    @org.junit.jupiter.api.Test
    public void dobaviJednuVakcinuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/vakcine/{id}",4)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(4)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tip", Matchers.is("Bolest")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.revakcinacija", Matchers.is(8)));
    }

    @org.junit.jupiter.api.Test
    public void obrisiPoIdVakcinuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/vakcine/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Ovaj i prethodni test se ne mogu pokrenuti istovremeno. Moze se ili sve obrisati ili pojedinacno
    /*
    @org.junit.jupiter.api.Test
    public void obrisiSveVakcineTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/vakcine")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @org.junit.jupiter.api.Test
    public void postVakcineTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/vakcine")
                .param("tip", "Random vakcina")
                .param("revakcinacija", "36"));
    }

    @org.junit.jupiter.api.Test
    public void putVakcineTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/vakcine/{id}",2)
                .content("tip=TestVakcine")
                .content("revakcinacija=6"));
    }
}
