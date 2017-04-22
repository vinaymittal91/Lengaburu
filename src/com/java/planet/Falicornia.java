package com.java.planet;

import com.java.Army;

import java.util.LinkedHashMap;

public class Falicornia extends Planet {


    public Falicornia(String planetName) {
        super(planetName);
    }

    @Override
    public LinkedHashMap<Army.Units, Integer> counter(Planet planet, double strenghtAgainstPlanet) {
        return null;
    }

    @Override
    public String findResult() {
        return null;
    }
}
