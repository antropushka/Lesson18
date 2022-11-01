package by.epam.lesson18.service;

import by.epam.lesson18.service.impl.ElectronicDeviceServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final ElectronicDeviceService electronicDeviceService = new ElectronicDeviceServiceImpl();

    private ServiceFactory() {
    }

    public ElectronicDeviceService getElectronicDeviceService() {

        return electronicDeviceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
