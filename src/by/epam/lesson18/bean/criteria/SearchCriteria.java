package by.epam.lesson18.bean.criteria;

public class SearchCriteria {

    public static enum SteamCleaner {
        BRAND, PRICE, WATER_HEATING_TIME, MAX_STEAM_PRESSURE
    }

    public static enum VacuumCleaner {
        BRAND, PRICE, CONSTRUCTION,  CONTAINER_VOLUME
    }

    public static enum WashingMachine {
        BRAND, PRICE, MAX_LOAD, MAX_SPIN_SPEED, NUM_OF_PROGRAMS

    }

    public SearchCriteria() {
    }
}
