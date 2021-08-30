package com.jaoo10.thatIsNoMoon;

import com.jaoo10.thatIsNoMoon.controller.PlanetRestController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.jaoo10.thatIsNoMoon.service.NextSequenceService;
import com.jaoo10.thatIsNoMoon.service.PlanetService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
                .andExpect(status().isCreated());
    }

    @Test
    public void getPlanetByName_200Test() throws Exception {

        var expectedJson = "{\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"Coruscant\",\n" +
                "    \"climate\": \"dunno\",\n" +
                "    \"terrain\": \"dunno also\",\n" +
                "    \"numberOfFilms\": 3\n" +
                "}";

        MvcResult result = mvc.perform(get("/planet/byName/Coruscant")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String actualJson = result.getResponse().getContentAsString();

        Assert.assertEquals(expectedJson, actualJson);


    }


}
