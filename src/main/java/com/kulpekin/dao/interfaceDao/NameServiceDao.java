package com.kulpekin.dao.interfaceDao;

import com.kulpekin.models.NameService;
import com.kulpekin.models.Service;

import java.util.List;

public interface NameServiceDao {
    void insertNameService(NameService nameService);
    void updateNameService(NameService nameService);
    void deleteNameService(int id);
    List<Service> listServices();
    NameService getNameServiceById(int id);
    List<NameService> listNameServices();
}
