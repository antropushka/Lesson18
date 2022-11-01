package by.epam.lesson18.dao.impl;

import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.criteria.Criteria;
import by.epam.lesson18.dao.DAOException;
import by.epam.lesson18.dao.FindDeviceDAO;
import by.epam.lesson18.dao.util.DeviceBuilder;
import by.epam.lesson18.dao.util.DeviceMatcher;
import by.epam.lesson18.dao.util.DeviceReader;

import java.util.*;

public class TxtFindDeviceDAO implements FindDeviceDAO {

    @Override
    public List<ElectronicDevice> find(Criteria criteria) throws DAOException {
        List<String> linesFromTxt = null;
        DeviceReader deviceReader = DeviceReader.getInstance();
        if (criteria.getGroupSearchName() != null) {
            linesFromTxt = deviceReader.take(criteria.getGroupSearchName());
        } else {
            linesFromTxt = deviceReader.takeAllLines();
        }

       DeviceMatcher deviceMatcher = new DeviceMatcher(linesFromTxt, criteria);
       List<String> matchedLines = deviceMatcher.match();
       DeviceBuilder deviceBuilder = new DeviceBuilder(matchedLines);
       List<ElectronicDevice> electronicDevices = deviceBuilder.build();

       return electronicDevices;
    }
}

