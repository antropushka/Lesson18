package by.epam.lesson18.main;

import by.epam.lesson18.bean.criteria.Criteria;
import by.epam.lesson18.bean.criteria.SearchCriteria;
import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.device.WashingMachine;
import by.epam.lesson18.dao.DAOException;
import by.epam.lesson18.dao.DAOFactory;
import by.epam.lesson18.dao.impl.TxtFindDeviceDAO;
import by.epam.lesson18.service.ServiceFactory;
import by.epam.lesson18.service.exception.ServiceException;

import java.io.FileNotFoundException;
import java.util.List;


public class Main {

    public static void main (String[] args) throws FileNotFoundException, ServiceException, DAOException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DAOFactory daoFactory = DAOFactory.getInstance();
        serviceFactory.getElectronicDeviceService();

        DevicesCreator.writeItemsToFile();

        List<ElectronicDevice> deviceList;

        Criteria criteria = new Criteria(WashingMachine.class.getSimpleName());
        criteria.addCriteria(SearchCriteria.WashingMachine.BRAND.name(), "Samsung");
        System.out.println(daoFactory.getApplianceDAO().find(criteria));




    }
}
