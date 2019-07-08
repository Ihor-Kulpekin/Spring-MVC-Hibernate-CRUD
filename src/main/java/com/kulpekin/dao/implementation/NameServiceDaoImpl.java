package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.NameServiceDao;
import com.kulpekin.models.NameService;
import com.kulpekin.models.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NameServiceDaoImpl implements NameServiceDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insertNameService(NameService nameService) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(nameService);
    }

    @Override
    public void updateNameService(NameService nameService) {
        Session session = sessionFactory.getCurrentSession();
        session.update(nameService);
    }

    @Override
    public void deleteNameService(int id) {
        Session session = sessionFactory.getCurrentSession();
        NameService nameService = session.get(NameService.class,id);

        if(nameService!=null){
            session.delete(nameService);
        }
    }

    @Override
    public NameService getNameServiceById(int id) {
        Session session = sessionFactory.getCurrentSession();
        NameService nameService = session.get(NameService.class,id);
        return nameService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NameService> listNameServices() {
        Session session = sessionFactory.getCurrentSession();
        List<NameService> nameServiceList = session.createQuery("from NameService").list();
        return nameServiceList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Service> listServices() {
        Session session = sessionFactory.getCurrentSession();

        List<Service> serviceList = session.createQuery("select name from Service").list();

        return serviceList;
    }
}
