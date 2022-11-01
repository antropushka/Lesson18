package by.epam.lesson18.dao;

import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.criteria.Criteria;

import java.io.FileNotFoundException;
import java.util.List;

public interface FindDeviceDAO {
    List<ElectronicDevice> find(Criteria criteria) throws FileNotFoundException, DAOException;

}
