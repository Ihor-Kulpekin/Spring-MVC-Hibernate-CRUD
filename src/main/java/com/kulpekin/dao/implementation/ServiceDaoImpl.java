package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.ServiceDao;
import com.kulpekin.models.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceDaoImpl implements ServiceDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addService(Service service) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(service);
    }

    @Override
    public void updateService(Service service) {
        Session session = sessionFactory.getCurrentSession();
        session.update(service);
    }

    @Override
    public Service getServiceById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Service service = session.get(Service.class,id);
        return service;
    }

    @Override
    public void removeService(int id) {
        Session session = sessionFactory.getCurrentSession();
        Service service = session.get(Service.class,id);
        if(null!=service){
            session.delete(service);
        }
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<Service> listServices() {
        Session session = sessionFactory.getCurrentSession();

        List<Service> serviceList = session.createQuery("from Service").list();

        return serviceList;
    }
}
