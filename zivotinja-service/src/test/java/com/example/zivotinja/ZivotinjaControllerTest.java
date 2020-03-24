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
public class ZivotinjaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @org.junit.jupiter.api.Test
    public void dobaviSveZiotinjeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/zivotinje")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ime", Matchers.is("Mini")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].rasa", Matchers.is("Labrador")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].vrsta", Matchers.is("Pas")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].godine", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].spol", Matchers.is("Z")));
    }

    @org.junit.jupiter.api.Test
    public void dobaviJednuZivotinjuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/zivotinje/{id}",2)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ime", Matchers.is("Viki")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dodatniOpis", Matchers.is("Preslatki mali cuko")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.godine", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.spol", Matchers.is("Z")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.velicina", Matchers.is("Mali pas")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.tezina", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.vrsta", Matchers.is("Pas")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.udomljena", Matchers.is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rasa", Matchers.is("Labrador")));
    }

    @org.junit.jupiter.api.Test
    public void obrisiPoIdZivotinjuTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/zivotinje/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Ovaj i prethodni test se ne mogu pokrenuti istovremeno. Moze se ili sve obrisati ili pojedinacno
    /*
    @org.junit.jupiter.api.Test
    public void obrisiSveZivotinjeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/zivotinje")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @org.junit.jupiter.api.Test
    public void postZivotinjeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/zivotinje")
                .param("dodatniOpis", "Slatkica mala")
                .param("ime", "Cicko")
                .param("godine", "3")
                .param("spol", "M")
                .param("velicina", "Mala macka")
                .param("tezina", "3")
                .param("vrsta", "Macka")
                .param("udomljena", "false")
                .param("rasa", "Ruska plava"));
    }

    @org.junit.jupiter.api.Test
    public void putZivotinjeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/zivotinje/{id}",2)
                .content("ime=Miki")
                .content("godine=5"));
    }
}
