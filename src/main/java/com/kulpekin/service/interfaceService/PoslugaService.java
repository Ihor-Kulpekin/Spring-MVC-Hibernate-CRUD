package com.kulpekin.service.interfaceService;

import com.kulpekin.models.Service;

import java.util.List;

public interface PoslugaService {
    void addService(Service service);
    void updateService(Service service);
    Service getServiceById(int id);
    void removeService(int id);
    List<Service> listServices();
}
