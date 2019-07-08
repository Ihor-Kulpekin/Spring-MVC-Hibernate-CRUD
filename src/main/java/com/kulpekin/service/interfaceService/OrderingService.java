package com.kulpekin.service.interfaceService;

import com.kulpekin.models.Client;
import com.kulpekin.models.NameService;
import com.kulpekin.models.Ordering;
import com.kulpekin.models.Worker;

import java.util.List;

public interface OrderingService {
    void addOrdering(Ordering ordering);
    void updateOrdering(Ordering ordering);
    Ordering getOrderingById(int id);
    void removeOrdering(int id);
    List<Ordering> listOrderings();
    List<NameService> listNameService();
    List<Client> listClients();
    List<Worker> listWorkers();
}
