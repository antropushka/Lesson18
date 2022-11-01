package by.epam.lesson18.service.impl;

import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.criteria.Criteria;
import by.epam.lesson18.dao.DAOException;
import by.epam.lesson18.dao.DAOFactory;
import by.epam.lesson18.dao.FindDeviceDAO;
import by.epam.lesson18.service.ElectronicDeviceService;
import by.epam.lesson18.service.exception.ServiceException;
import by.epam.lesson18.service.validation.Validator;

import java.io.FileNotFoundException;
import java.util.List;

public class ElectronicDeviceServiceImpl implements ElectronicDeviceService {

    @Override
    public List<ElectronicDevice> find(Criteria criteria) throws ServiceException {
        List<ElectronicDevice> devices = null;
        if (!Validator.criteriaValidator(criteria)) {
           return null;
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        FindDeviceDAO electricalApplianceDAOImpl = daoFactory.getApplianceDAO();
        try {
            devices = electricalApplianceDAOImpl.find(criteria);
        } catch (FileNotFoundException | DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return devices;

    }
}
