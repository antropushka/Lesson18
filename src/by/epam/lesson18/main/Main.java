package by.epam.lesson18.main;

import by.epam.lesson18.bean.criteria.Criteria;
import by.epam.lesson18.bean.criteria.SearchCriteria;
import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.device.WashingMachine;
import by.epam.lesson18.dao.DAOException;
import by.epam.lesson18.dao.DAOFactory;
import by.epam.lesson18.dao.FindDeviceDAO;
import by.epam.lesson18.service.exception.ServiceException;

import java.io.FileNotFoundException;
import java.util.List;


public class Main {

    public static void main (String[] args) throws FileNotFoundException, ServiceException, DAOException {

        DevicesCreator.writeItemsToFile();
        List<ElectronicDevice> deviceList;
        DAOFactory daoFactory = DAOFactory.getInstance();
        FindDeviceDAO findDeviceDAO = daoFactory.getApplianceDAO();

        Criteria criteria = new Criteria(WashingMachine.class.getSimpleName());
        criteria.addCriteria(SearchCriteria.WashingMachine.BRAND.name(), "Samsung");

        deviceList = findDeviceDAO.find(criteria);
        for (int i = 0; i < deviceList.size(); i++) {
            System.out.println(deviceList.get(i));
        }







    }
}
