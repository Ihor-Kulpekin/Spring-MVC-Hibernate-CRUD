package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.ClientDao;
import com.kulpekin.models.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(client);
    }

    @Override
    public void updateClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    @Override
    public Client getClientById(int id) {

        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class,id);

        return client;
    }

    @Override
    public void removeClient(int id) {
        Session session = sessionFactory.getCurrentSession();
        Client client = session.get(Client.class,id);

        if(client!=null){
            session.delete(client);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> listClients() {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clientList = session.createQuery("from Client").list();
        return clientList;
    }
}
