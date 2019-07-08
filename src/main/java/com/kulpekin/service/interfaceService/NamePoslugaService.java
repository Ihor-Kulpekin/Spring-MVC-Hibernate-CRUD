package com.kulpekin.service.interfaceService;

import com.kulpekin.models.NameService;
import com.kulpekin.models.Service;

import java.util.List;

public interface NamePoslugaService {
    void insertNameService(NameService nameService);
    void updateNameService(NameService nameService);
    void deleteNameService(int id);
    NameService getNameServiceById(int id);
    List<NameService> listNameServices();
    List<Service> listServices();
}
