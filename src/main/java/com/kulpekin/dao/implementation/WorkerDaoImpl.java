package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.WorkerDao;
import com.kulpekin.models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoImpl implements WorkerDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addWorker(Worker worker) {
       Session session= sessionFactory.getCurrentSession();
       session.persist(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session= sessionFactory.getCurrentSession();
        session.update(worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        Session session= sessionFactory.getCurrentSession();
        Worker worker = session.get(Worker.class,id);
        return worker;
    }

    @Override
    public void removeWorker(int id) {
        Session session= sessionFactory.getCurrentSession();
        Worker worker = session.get(Worker.class,id);
        if(null!=worker){
            session.delete(worker);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Worker> listWorkers() {
        Session session= sessionFactory.getCurrentSession();

        List<Worker> workerList = session.createQuery("from Worker").list();
        return workerList;
    }
}
