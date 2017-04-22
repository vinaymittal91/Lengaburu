package com.java.planet;

import com.java.Army;

import java.util.LinkedHashMap;

public abstract class Planet {
    String planetName;
    Army army;

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Army getArmy() {
        return army;
    }

    public abstract LinkedHashMap<Army.Units, Integer> counter(Planet planet, double strenghtAgainstPlanet);

    public abstract String findResult();

}
