package com.java;


import java.util.LinkedHashMap;

public class Army {

    private LinkedHashMap<Units,Integer> mapArmy = new LinkedHashMap<>();

    public enum Units {
        HORSE, ELEPHANTS, ARMOURED_TANKS, SLING_GUNS;

        private static Units[] units = values();

        public Units next() {
            return ordinal() < (units.length-1) ? units[ordinal()+1] : null;
        }

        public Units previous() {
            return ordinal() > 0 ? units[ordinal()-1] : null;
        }
    }
    
    public void addUnit(Units unit, int value) {
        mapArmy.put(unit,value);
    }
    
    /*
    

    public Army(int numberOfHorse, int noOfElephants, int noOfTanks, int noOfGuns) {
        mapArmy.put(Units.HORSE,numberOfHorse);
        mapArmy.put(Units.ELEPHANTS,noOfElephants);
        mapArmy.put(Units.ARMOURED_TANKS, noOfTanks);
        mapArmy.put(Units.SLING_GUNS,noOfGuns);
    }*/

    public LinkedHashMap<Units, Integer> getArmy() {
        return mapArmy;
    }



}
