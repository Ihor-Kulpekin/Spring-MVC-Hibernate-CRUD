package com.kulpekin.service.implementation;

import com.kulpekin.dao.interfaceDao.WorkerDao;
import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {


    private WorkerDao workerDao;

    @Autowired
    public void setWorkerDao(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @Override
    @Transactional
    public void addWorker(Worker worker) {
        workerDao.addWorker(worker);
    }

    @Override
    @Transactional
    public void updateWorker(Worker worker) {
        workerDao.updateWorker(worker);
    }

    @Override
    @Transactional
    public Worker getWorkerById(int id){
        return workerDao.getWorkerById(id);
    }

    @Override
    @Transactional
    public void removeWorker(int id) {
        workerDao.removeWorker(id);
    }

    @Override
    @Transactional
    public List<Worker> listWorkers() {
        return workerDao.listWorkers();
    }
}
