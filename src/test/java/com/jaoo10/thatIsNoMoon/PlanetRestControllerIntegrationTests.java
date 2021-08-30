package com.jaoo10.thatIsNoMoon;

import com.jaoo10.thatIsNoMoon.controller.PlanetRestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.jaoo10.thatIsNoMoon.service.NextSequenceService;
import com.jaoo10.thatIsNoMoon.service.PlanetService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetRestController.class)
public class PlanetRestControllerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlanetService planetService;

    @MockBean
    private NextSequenceService nextSequenceService;

    @Test
    public void readApiAllPlanets_200Test() throws Exception {
        mvc.perform(get("/planet/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void readOriginalApiAllPlanets_200Test() throws Exception {
        mvc.perform(get("/planet/readOriginal/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void savePlanet_201Test() throws Exception {

        JSONObject jsonObject = new JSONObject("{\"name\":\"Testooine\",\"climate\":\"Arid\",\"terrain\":\"desert\"}");

        mvc.perform(post("/planet/save")
                        .content(String.valueOf(jsonObject))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().string("Planet added successfully"));
    }

    @Test
    public void getPlanetByName_200Test() throws Exception {

        mvc.perform(get("/planet/byName/Coruscant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveThenGetPlanetByNameTest() throws Exception {

        JSONObject jsonObject = new JSONObject("{\"name\":\"Testooine\",\"climate\":\"Arid\",\"terrain\":\"desert\"}");

        mvc.perform(post("/planet/save")
                        .content(String.valueOf(jsonObject))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(result -> mvc.perform(get("/planet/byName/Testooine"))
                                .andExpect(status().isOk()));
    }

    @Test
    public void getPlanetById_200Test() throws Exception {

        mvc.perform(get("/planet/byId/2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePlanet_200Test() throws Exception {

        mvc.perform(delete("/planet/delete/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Planet deleted successfully"));
    }


}
