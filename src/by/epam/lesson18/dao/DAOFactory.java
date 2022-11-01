package by.epam.lesson18.dao;

import by.epam.lesson18.dao.impl.TxtFindDeviceDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final FindDeviceDAO findDeviceDAO = new TxtFindDeviceDAO();

    private DAOFactory() {
    }

    public FindDeviceDAO getApplianceDAO() {
        return findDeviceDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
