package com.jaoo10.thatIsNoMoon.service;

import com.jaoo10.thatIsNoMoon.entity.Planet;

import java.util.List;

public interface PlanetService {

    public void save(String name, String climate, String terrain, Long numberOfFilms);

    public List<Planet> findAll();

    public long count();

    public Planet findById(Integer id);

    public Planet findByName(String name);

    public void delete(Integer id);
}
