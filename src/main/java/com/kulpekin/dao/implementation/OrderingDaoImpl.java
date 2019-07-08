package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.OrderingDao;
import com.kulpekin.models.Client;
import com.kulpekin.models.NameService;
import com.kulpekin.models.Ordering;
import com.kulpekin.models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderingDaoImpl implements OrderingDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrdering(Ordering ordering) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(ordering);
    }

    @Override
    public void updateOrdering(Ordering ordering) {
        Session session = sessionFactory.getCurrentSession();
        session.update(ordering);
    }

    @Override
    public Ordering getOrderingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ordering ordering = session.get(Ordering.class,id);
        return ordering;
    }

    @Override
    public void removeOrdering(int id) {
        Session session = sessionFactory.getCurrentSession();
        Ordering ordering = session.get(Ordering.class,id);
        if(ordering!=null){
            session.delete(ordering);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Ordering> listOrderings() {
        Session session = sessionFactory.getCurrentSession();
        List<Ordering> orderingList = session.createQuery("from Ordering").list();
        return orderingList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NameService> listNameService() {
        Session session = sessionFactory.getCurrentSession();
        List<NameService> nameServiceList = session.createQuery("select id from NameService").list();
        return nameServiceList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> listClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clientList = session.createQuery("select id from Client").list();
        return clientList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Worker> listWorkers() {
        Session session = sessionFactory.getCurrentSession();
        List<Worker> workerList = session.createQuery("select id from Worker").list();
        return workerList;
    }
}
