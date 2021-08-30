package com.jaoo10.thatIsNoMoon.service;

import com.jaoo10.thatIsNoMoon.entity.Planet;
import com.jaoo10.thatIsNoMoon.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private NextSequenceServiceImpl nextSequenceService;

    public void save(String name, String climate, String terrain, Long numberOfFilms) {
        planetRepository.save(new Planet(nextSequenceService.getNextSequence("customSequences"),name, climate,terrain,numberOfFilms));
    }

    public List<Planet> findAll() {
        return planetRepository.findAll();
    }

    public long count() {
        return planetRepository.count();
    }

    public Planet findById(Integer id) {
        return planetRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "item not found"));
    }

    public Planet findByName(String name) {
        return planetRepository.findByName(name);
    }

    public void delete(Integer id) {
        Planet planet = findById(id);
        planetRepository.delete(planet);
    }
}
