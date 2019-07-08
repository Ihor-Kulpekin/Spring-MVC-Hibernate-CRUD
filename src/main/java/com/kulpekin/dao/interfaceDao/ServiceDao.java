package com.kulpekin.dao.interfaceDao;

import com.kulpekin.models.Service;

import java.util.List;

public interface ServiceDao {
    void addService(Service service);
    void updateService(Service service);
    Service getServiceById(int id);
    void removeService(int id);
    List<Service> listServices();
}
