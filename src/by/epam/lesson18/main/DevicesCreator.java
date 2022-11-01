package by.epam.lesson18.main;

import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.device.SteamCleaner;
import by.epam.lesson18.bean.device.VacuumCleaner;
import by.epam.lesson18.bean.device.WashingMachine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DevicesCreator {

    private static List<ElectronicDevice> createListOfDevices() {

        List<ElectronicDevice> devices = new ArrayList<ElectronicDevice>();
        devices.add(new SteamCleaner("Deerma", 600.0, 2.0, 7.0));
        devices.add(new SteamCleaner("Karher", 2000.0, 7.0, 10.0));
        devices.add(new VacuumCleaner("Dayson", 1800.0, "вертикальный", 1.5));
        devices.add(new VacuumCleaner("Dayson", 2800.0, "вертикальный", 2.5));
        devices.add(new WashingMachine("Samsung", 1600.0, 8.0, 1200.0, 21));
        devices.add(new WashingMachine("Atlant", 700.0, 5.0, 800.0, 7));


        return devices;
    }

    public static void writeItemsToFile() {
        File file = new File("DeviceList.txt");
        BufferedWriter bf = null;
        try {
            List<ElectronicDevice> deviceList = createListOfDevices();
            bf = new BufferedWriter(new FileWriter(file));
            for (ElectronicDevice device : deviceList) {
                bf.write(device.toString());
                bf.newLine();
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
