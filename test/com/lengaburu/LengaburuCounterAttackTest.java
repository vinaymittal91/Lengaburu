package com.lengaburu;

import com.java.Army;
import com.java.planet.Falicornia;
import com.java.planet.Lengaburu;
import com.java.planet.Planet;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.junit.Assert.*;

public class LengaburuCounterAttackTest {

    Planet lengaburu, falicornia;

    Army alFalconeArmy = new Army();
    Army expectedOutputArmy = new Army();
    Army kingShanArmy = new Army();


    double strengthAgainstPlanet = 0.5;

    @Before
    public void setUp() throws Exception {
        kingShanArmy.addUnit(Army.Units.HORSE,100);
        kingShanArmy.addUnit(Army.Units.ELEPHANTS,50);
        kingShanArmy.addUnit(Army.Units.ARMOURED_TANKS,10);
        kingShanArmy.addUnit(Army.Units.SLING_GUNS,5);

        lengaburu = new Lengaburu("Lengaburu");

        lengaburu.setArmy(kingShanArmy);

        falicornia = new Falicornia("Falicornia");
    }

    @Test
    public void forFirstSampleInput() {
        alFalconeArmy.addUnit(Army.Units.HORSE,2);
        alFalconeArmy.addUnit(Army.Units.ELEPHANTS,2);
        alFalconeArmy.addUnit(Army.Units.ARMOURED_TANKS,2);
        alFalconeArmy.addUnit(Army.Units.SLING_GUNS,2);

        falicornia.setArmy(alFalconeArmy);

        expectedOutputArmy.addUnit(Army.Units.HORSE,1);
        expectedOutputArmy.addUnit(Army.Units.ELEPHANTS,1);
        expectedOutputArmy.addUnit(Army.Units.ARMOURED_TANKS,1);
        expectedOutputArmy.addUnit(Army.Units.SLING_GUNS,1);

        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(falicornia, strengthAgainstPlanet);
        assertEquals(expectedOutputArmy.getArmy(), deployedArmy);
        assertTrue(lengaburu.findResult().equalsIgnoreCase("wins"));
    }

    @Test
    public void forSecondSampleInput() {
        alFalconeArmy.addUnit(Army.Units.HORSE,204);
        alFalconeArmy.addUnit(Army.Units.ELEPHANTS,20);
        alFalconeArmy.addUnit(Army.Units.ARMOURED_TANKS,0);
        alFalconeArmy.addUnit(Army.Units.SLING_GUNS,0);

        falicornia.setArmy(alFalconeArmy);

        expectedOutputArmy.addUnit(Army.Units.HORSE,100);
        expectedOutputArmy.addUnit(Army.Units.ELEPHANTS,11);
        expectedOutputArmy.addUnit(Army.Units.ARMOURED_TANKS,0);
        expectedOutputArmy.addUnit(Army.Units.SLING_GUNS,0);


        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(falicornia, strengthAgainstPlanet);
        assertEquals(expectedOutputArmy.getArmy(), deployedArmy);
        assertTrue(lengaburu.findResult().equalsIgnoreCase("wins"));
    }

    @Test
    public void forThirdSampleInput() {
        alFalconeArmy.addUnit(Army.Units.HORSE,100);
        alFalconeArmy.addUnit(Army.Units.ELEPHANTS,101);
        alFalconeArmy.addUnit(Army.Units.ARMOURED_TANKS,20);
        alFalconeArmy.addUnit(Army.Units.SLING_GUNS,5);

        falicornia.setArmy(alFalconeArmy);

        expectedOutputArmy.addUnit(Army.Units.HORSE,52);
        expectedOutputArmy.addUnit(Army.Units.ELEPHANTS,50);
        expectedOutputArmy.addUnit(Army.Units.ARMOURED_TANKS,10);
        expectedOutputArmy.addUnit(Army.Units.SLING_GUNS,3);

        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(falicornia, strengthAgainstPlanet);
        assertEquals(expectedOutputArmy.getArmy(), deployedArmy);
        assertTrue(lengaburu.findResult().equalsIgnoreCase("wins"));
    }

    @Test
    public void forFourthSampleInput() {
        alFalconeArmy.addUnit(Army.Units.HORSE,150);
        alFalconeArmy.addUnit(Army.Units.ELEPHANTS,96);
        alFalconeArmy.addUnit(Army.Units.ARMOURED_TANKS,26);
        alFalconeArmy.addUnit(Army.Units.SLING_GUNS,8);

        falicornia.setArmy(alFalconeArmy);

        expectedOutputArmy.addUnit(Army.Units.HORSE,75);
        expectedOutputArmy.addUnit(Army.Units.ELEPHANTS,50);
        expectedOutputArmy.addUnit(Army.Units.ARMOURED_TANKS,10);
        expectedOutputArmy.addUnit(Army.Units.SLING_GUNS,5);

        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(falicornia, strengthAgainstPlanet);
        assertEquals(expectedOutputArmy.getArmy(), deployedArmy);
        assertTrue(lengaburu.findResult().equalsIgnoreCase("wins"));

    }

    @Test
    public void forFifthSampleInput() {
        alFalconeArmy.addUnit(Army.Units.HORSE,250);
        alFalconeArmy.addUnit(Army.Units.ELEPHANTS,50);
        alFalconeArmy.addUnit(Army.Units.ARMOURED_TANKS,20);
        alFalconeArmy.addUnit(Army.Units.SLING_GUNS,15);

        falicornia.setArmy(alFalconeArmy);

        expectedOutputArmy.addUnit(Army.Units.HORSE,100);
        expectedOutputArmy.addUnit(Army.Units.ELEPHANTS,38);
        expectedOutputArmy.addUnit(Army.Units.ARMOURED_TANKS,10);
        expectedOutputArmy.addUnit(Army.Units.SLING_GUNS,5);

        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(falicornia, strengthAgainstPlanet);
        assertEquals(expectedOutputArmy.getArmy(), deployedArmy);
        assertTrue(lengaburu.findResult().equalsIgnoreCase("loose"));
    }





}
