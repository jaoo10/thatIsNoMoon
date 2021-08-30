package com.jaoo10.thatIsNoMoon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tb_planet")
@Data
@AllArgsConstructor
public class Planet {

    @Id
    private Integer id;
    private String name;
    private String climate;
    private String terrain;
    private Long numberOfFilms;

}
