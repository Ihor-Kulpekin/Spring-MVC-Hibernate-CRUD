package com.kulpekin.service.implementation;

import com.kulpekin.dao.interfaceDao.NameServiceDao;
import com.kulpekin.models.NameService;
import com.kulpekin.service.interfaceService.NamePoslugaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NamePoslugaServiceImpl implements NamePoslugaService {

    private NameServiceDao nameServiceDao;

    @Autowired
    public void setNameServiceDao(NameServiceDao nameServiceDao) {
        this.nameServiceDao = nameServiceDao;
    }

    @Transactional
    @Override
    public void insertNameService(NameService nameService) {
        nameServiceDao.insertNameService(nameService);
    }

    @Transactional
    @Override
    public void updateNameService(NameService nameService) {
        nameServiceDao.updateNameService(nameService);
    }

    @Transactional
    @Override
    public void deleteNameService(int id) {
        nameServiceDao.deleteNameService(id);
    }

    @Transactional
    @Override
    public NameService getNameServiceById(int id) {
        return nameServiceDao.getNameServiceById(id);
    }

    @Transactional
    @Override
    public List<NameService> listNameServices() {
        return nameServiceDao.listNameServices();
    }

    @Transactional
    @Override
    public List<com.kulpekin.models.Service> listServices() {
        return nameServiceDao.listServices();
    }
}
