package com.jaoo10.thatIsNoMoon.repository;

import com.jaoo10.thatIsNoMoon.entity.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetRepository extends MongoRepository<Planet, Integer> {

    Planet findByName(String name);
}
