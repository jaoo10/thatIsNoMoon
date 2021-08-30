package com.jaoo10.thatIsNoMoon.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jaoo10.thatIsNoMoon.entity.Planet;
import com.jaoo10.thatIsNoMoon.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetRestController {

    @Autowired
    private PlanetService planetService;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/")
    public List<Planet> getAllPlanets() {
        return planetService.findAll();
    }

    @GetMapping(value = "/byId/{id}")
    public Planet getPlanetById(@PathVariable("id") Integer id) {
        return planetService.findById(id);
    }

    @GetMapping(value = "/byName/{name}")
    public Planet getPlanetByName(@PathVariable("name") String name) {
        return planetService.findByName(name);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> savePlanet(@RequestBody Planet planet) {
        planetService.save(planet.getName(),planet.getClimate(), planet.getTerrain(),planet.getNumberOfFilms());
        return new ResponseEntity("Planet added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePlanetById(@PathVariable("id") Integer id) {
        planetService.delete(id);
        return new ResponseEntity("Planet deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/readOriginal")
    public String readOriginal() throws JsonProcessingException {

        return restTemplate.getForObject("https://swapi.dev/api/planets",
                String.class);
    }

}
