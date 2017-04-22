package com.java;

import com.java.planet.Falicornia;
import com.java.planet.Lengaburu;
import com.java.planet.Planet;
import java.util.LinkedHashMap;

public class War {

    public static void main(String[] args) {
        Army kingShanArmy = new Army();
        kingShanArmy.addUnit(Army.Units.HORSE,100);
        kingShanArmy.addUnit(Army.Units.ELEPHANTS,50);
        kingShanArmy.addUnit(Army.Units.ARMOURED_TANKS,10);
        kingShanArmy.addUnit(Army.Units.SLING_GUNS,5);

        Army falicorniaArmy = new Army();

        falicorniaArmy.addUnit(Army.Units.HORSE,150);
        falicorniaArmy.addUnit(Army.Units.ELEPHANTS,96);
        falicorniaArmy.addUnit(Army.Units.ARMOURED_TANKS,26);
        falicorniaArmy.addUnit(Army.Units.SLING_GUNS,8);

        Planet lengaburu = new Lengaburu("Lengaburu");

        lengaburu.setArmy(kingShanArmy);

        Planet faclicornia = new Falicornia("Falicornia");

        faclicornia.setArmy(falicorniaArmy);

        LinkedHashMap<Army.Units, Integer> deployedArmy = lengaburu.counter(faclicornia, 0.5);
        System.out.println("Lengaburu deploys : " + deployedArmy +" And " + lengaburu.findResult());

        }
}
