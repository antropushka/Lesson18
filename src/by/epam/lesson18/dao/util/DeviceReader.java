package by.epam.lesson18.dao.util;

import by.epam.lesson18.dao.DAOException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeviceReader {

    private final File deviceListTxt = new File("DeviceList.txt");
    private static final DeviceReader instance = new DeviceReader();

    private final String STEAM_CLEANER = "SteamCleaner";
    private final String VACUUM_CLEANER = "VacuumCleaner";
    private final String WASHING_MACHINE = "WashingMachine";

    public DeviceReader() {
    }

    public static DeviceReader getInstance() {
        return instance;
    }
    public List<String> take(String groupName) throws DAOException {
        List<String> specificCategoriesLines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(deviceListTxt))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith(groupName) && groupName.equals(STEAM_CLEANER)) {
                    specificCategoriesLines.add(line);
                } else if (line.startsWith(groupName) && groupName.equals(VACUUM_CLEANER)) {
                    specificCategoriesLines.add(line);
                } else if (line.startsWith(groupName) && groupName.equals(WASHING_MACHINE)) {
                    specificCategoriesLines.add(line);
                }
            }
        } catch (IOException e) {
            throw new DAOException("there is no such file", e);
        }
        return specificCategoriesLines;
    }

    public List<String> takeAllLines() throws DAOException {
        List<String> allLines = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(deviceListTxt))) {
            allLines = bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new DAOException("there is no such file", e);
        }
        return allLines;
    }
}
