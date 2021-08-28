package com.jaoo10.thatIsNoMoon.controller;

import com.jaoo10.thatIsNoMoon.entity.Planet;
import com.jaoo10.thatIsNoMoon.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetRestController {

    @Autowired
    private PlanetService planetService;

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
        return new ResponseEntity("Planet added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deletePlanetById(@PathVariable("id") Integer id) {
        planetService.delete(id);
        return new ResponseEntity("Planet deleted successfully", HttpStatus.OK);
    }

}
