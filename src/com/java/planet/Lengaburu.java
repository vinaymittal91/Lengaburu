package com.java.planet;


import com.java.Army;

import java.util.LinkedHashMap;

public class Lengaburu extends Planet {

    LinkedHashMap<Army.Units, Integer> mapOfMyArmy;
    LinkedHashMap<Army.Units, Integer> mapOfEnemyArmy;

    LinkedHashMap<Army.Units, Integer> deployedBattalion;
    int totalStrengthOfMyArmy;

    public Lengaburu(String planetName) {
        super(planetName);
        deployedBattalion = new LinkedHashMap<>();
    }

    @Override
    public LinkedHashMap<Army.Units, Integer> counter(Planet enemyPlanet, double strengthAgainstPlanet) {
        mapOfMyArmy = this.army.getArmy();
        mapOfEnemyArmy = enemyPlanet.army.getArmy();

        return findDeployedArmyOfEnemy(mapOfEnemyArmy, strengthAgainstPlanet);
    }

    private LinkedHashMap<Army.Units, Integer> findDeployedArmyOfEnemy(LinkedHashMap<Army.Units, Integer> mapOfEnemyArmy, double strengthAgainstPlanet) {

        for(Army.Units unit : mapOfEnemyArmy.keySet()) {

            mapOfEnemyArmy.replace(unit, (int) Math.ceil(mapOfEnemyArmy.get(unit) * strengthAgainstPlanet));
            totalStrengthOfMyArmy = totalStrengthOfMyArmy+mapOfMyArmy.get(unit);

            int difference = mapOfMyArmy.get(unit) - mapOfEnemyArmy.get(unit);

            if(difference>=0) {
                deploy(deployedBattalion,unit,mapOfEnemyArmy.get(unit));
                mapOfMyArmy.replace(unit,difference);

            } else {
                int differenceFromLeftUnit = 0;
                Army.Units previousUnit = unit.previous();
                deploy(deployedBattalion, unit, mapOfMyArmy.get(unit));

                if (mapOfEnemyArmy.get(previousUnit) != null) {                                  // Look Back For Help
                    differenceFromLeftUnit = mapOfMyArmy.get(previousUnit)/2 + difference;
                    if(differenceFromLeftUnit>=0) {
                        deploy(deployedBattalion, previousUnit, -difference*2);
                    } else {
                        deploy(deployedBattalion,previousUnit,mapOfMyArmy.get(previousUnit));
                    }
                }

                Army.Units nextUnit = unit.next();                                              // Look Forward For Help

                if(differenceFromLeftUnit > 0) {
                    continue;
                }
                else if(differenceFromLeftUnit == 0 && mapOfEnemyArmy.get(nextUnit)!=null) {
                    deploy(deployedBattalion,nextUnit,(int)Math.ceil(-difference/2.0));
                }
                else if(mapOfEnemyArmy.get(nextUnit)!=null && differenceFromLeftUnit !=0 ) {
                    deploy(deployedBattalion,nextUnit,(int)Math.ceil(-difference/4.0));
                }
            }

        }

        return deployedBattalion;
    }

    private void deploy(LinkedHashMap<Army.Units, Integer> mapToPut, Army.Units soldier, Integer value) {
        mapToPut.compute(soldier, (k, v) -> v == null? value : v + value);
    }

    @Override
    public String findResult() {
        int totalStrenghtOfEnemyArmy = mapOfEnemyArmy.values().stream().mapToInt(Number::intValue).sum();
        String result = totalStrengthOfMyArmy>=totalStrenghtOfEnemyArmy ? "Wins" : "Loose";
        return result;
    }


}