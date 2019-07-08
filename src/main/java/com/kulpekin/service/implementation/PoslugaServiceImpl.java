package com.kulpekin.service.implementation;

import com.kulpekin.dao.interfaceDao.ServiceDao;
import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.PoslugaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class PoslugaServiceImpl implements PoslugaService {

    private ServiceDao serviceDao;

    @Autowired
    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    @Override
    @Transactional
    public void addService(Service service) {
        serviceDao.addService(service);
    }

    @Override
    @Transactional
    public void updateService(Service service) {
        serviceDao.updateService(service);
    }

    @Override
    @Transactional
    public Service getServiceById(int id) {
        return serviceDao.getServiceById(id);
    }

    @Override
    @Transactional
    public void removeService(int id) {
        serviceDao.removeService(id);
    }

    @Override
    @Transactional
    public List<Service> listServices() {
        return serviceDao.listServices();
    }
}
