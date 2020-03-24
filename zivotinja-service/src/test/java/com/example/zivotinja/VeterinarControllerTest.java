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
public class VeterinarControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @org.junit.jupiter.api.Test
    public void dobaviSveVeterinareTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/veterinari")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ime", Matchers.is("Abdulah")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].prezime", Matchers.is("Simic")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].adresa", Matchers.is("Paromlinska 52")));
    }

    @org.junit.jupiter.api.Test
    public void dobaviJednogVeterinarTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/veterinari/{id}",3)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ime", Matchers.is("Amila")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.prezime", Matchers.is("Perenda")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.adresa", Matchers.is("Paromlinska 52")));
    }

    @org.junit.jupiter.api.Test
    public void obrisiPoIdVeterinaraTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/veterinari/{id}",1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    // Ovaj i prethodni test se ne mogu pokrenuti istovremeno. Moze se ili sve obrisati ili pojedinacno
    /*
    @org.junit.jupiter.api.Test
    public void obrisiSveVeterinareTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/veterinari")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }*/

    @org.junit.jupiter.api.Test
    public void postVeterinaraTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/veterinari")
                .param("ime", "Alma")
                .param("prezime", "Ibrasimovic")
                .param("adresa", "Sarajevo 123"));
    }

    @org.junit.jupiter.api.Test
    public void putVeterinaraTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/veterinari/{id}",2)
                .content("ime=Lejla")
                .content("prezime=Silajdzija")
                .content("adresa=Nerkeza 132"));
    }
}
