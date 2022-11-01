package by.epam.lesson18.dao.util;

import by.epam.lesson18.bean.criteria.SearchCriteria;
import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.device.SteamCleaner;
import by.epam.lesson18.bean.device.VacuumCleaner;
import by.epam.lesson18.bean.device.WashingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceBuilder {

    private final String KEY_VALUE_PATTERN = "\\w+=\\w+\\.\\w+|\\w+=\\w+";
    private final Pattern pattern = Pattern.compile(KEY_VALUE_PATTERN);

    private final String STEAM_CLEANER = "Steam cleaner";
    private final String VACUUM_CLEANER = "Vacuum cleaner";
    private final String WASHING_MACHINE = "Washing machine";

    private final int STEAM_CLEANER_CRITERIA_LENGTH = SearchCriteria.SteamCleaner.values().length;
    private final int VACUUM_CLEANER_CRITERIA_LENGTH = SearchCriteria.VacuumCleaner.values().length;
    private final int WASHING_MACHINE_CRITERIA_LENGTH = SearchCriteria.WashingMachine.values().length;

    private List<String> matchedDeviceLines;

    public DeviceBuilder(List<String> matchedDeviceLines) {
        this.matchedDeviceLines = matchedDeviceLines;
    }

    public List<ElectronicDevice> build() {
        List<ElectronicDevice> devices = new ArrayList<>();

        for (String line : matchedDeviceLines) {
            int index = 0;
            Matcher matcher = pattern.matcher(line);
            if (line.startsWith(STEAM_CLEANER)) {

                String[] steamCleanerCriteries = new String[STEAM_CLEANER_CRITERIA_LENGTH];
                while (matcher.find()) {
                    steamCleanerCriteries[index++] = matcher.group().split("=")[1];
                }
                SteamCleaner steamCleaner = new SteamCleaner(steamCleanerCriteries[0],
                        Double.parseDouble(steamCleanerCriteries[1]),
                        Double.parseDouble(steamCleanerCriteries[2]),
                        Double.parseDouble(steamCleanerCriteries[3]));
                devices.add(steamCleaner);

            } else if (line.startsWith(VACUUM_CLEANER)) {
                String[] vacuumCleanerCriteries = new String[VACUUM_CLEANER_CRITERIA_LENGTH];
                while (matcher.find()) {
                    vacuumCleanerCriteries[index++] = matcher.group().split("=")[1];
                }
                VacuumCleaner vacuumCleaner = new VacuumCleaner(vacuumCleanerCriteries[0],
                        Double.parseDouble(vacuumCleanerCriteries[1]),
                        vacuumCleanerCriteries[2],
                        Double.parseDouble(vacuumCleanerCriteries[3]));
                devices.add(vacuumCleaner);
            } else if (line.startsWith(WASHING_MACHINE)) {
                String[] washingMachineCriteries = new String[WASHING_MACHINE_CRITERIA_LENGTH];
                while (matcher.find()) {
                    washingMachineCriteries[index++] = matcher.group().split("=")[1];
                }
                WashingMachine washingMachine = new WashingMachine(washingMachineCriteries[0],
                        Double.parseDouble(washingMachineCriteries[1]),
                        Double.parseDouble(washingMachineCriteries[2]),
                        Double.parseDouble(washingMachineCriteries[3]),
                        Integer.parseInt(washingMachineCriteries[4]));
                devices.add(washingMachine);
            }
        }
        return devices;
    }

}
