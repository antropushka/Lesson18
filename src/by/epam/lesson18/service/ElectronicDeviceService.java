package by.epam.lesson18.service;

import by.epam.lesson18.bean.device.ElectronicDevice;
import by.epam.lesson18.bean.criteria.Criteria;
import by.epam.lesson18.service.exception.ServiceException;

import java.util.List;

public interface ElectronicDeviceService {

    List<ElectronicDevice> find(Criteria criteria) throws ServiceException;



}
