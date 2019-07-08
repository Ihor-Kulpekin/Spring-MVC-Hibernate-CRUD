package com.kulpekin.service.implementation;

import com.kulpekin.dao.interfaceDao.OrderingDao;
import com.kulpekin.models.Client;
import com.kulpekin.models.NameService;
import com.kulpekin.models.Ordering;
import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.OrderingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderingServiceImpl implements OrderingService {

    private OrderingDao orderingDao;

    @Autowired
    public void setOrderingDao(OrderingDao orderingDao) {
        this.orderingDao = orderingDao;
    }

    @Transactional
    @Override
    public void addOrdering(Ordering ordering) {
        orderingDao.addOrdering(ordering);
    }

    @Transactional
    @Override
    public void updateOrdering(Ordering ordering) {
        orderingDao.updateOrdering(ordering);
    }

    @Transactional
    @Override
    public Ordering getOrderingById(int id) {
        return orderingDao.getOrderingById(id);
    }

    @Transactional
    @Override
    public void removeOrdering(int id) {
        orderingDao.removeOrdering(id);
    }

    @Transactional
    @Override
    public List<Ordering> listOrderings() {
        return orderingDao.listOrderings();
    }

    @Transactional
    @Override
    public List<NameService> listNameService() {
        return orderingDao.listNameService();
    }

    @Transactional
    @Override
    public List<Client> listClients() {
        return orderingDao.listClients();
    }

    @Transactional
    @Override
    public List<Worker> listWorkers() {
        return orderingDao.listWorkers();
    }
}
