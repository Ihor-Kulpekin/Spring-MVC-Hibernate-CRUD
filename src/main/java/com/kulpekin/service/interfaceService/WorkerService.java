package com.kulpekin.service.interfaceService;

import com.kulpekin.models.Worker;

import java.util.List;

public interface WorkerService {
    void addWorker(Worker worker);
    void updateWorker(Worker worker);
    Worker getWorkerById(int id);
    void removeWorker(int id);
    List<Worker> listWorkers();
}
