package com.kulpekin.dao.interfaceDao;

import com.kulpekin.models.Worker;

import java.util.List;

public interface WorkerDao {
    void addWorker(Worker worker);
    void updateWorker(Worker worker);
    Worker getWorkerById(int id);
    void removeWorker(int id);
    List<Worker> listWorkers();
}
