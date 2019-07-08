package com.kulpekin.service.interfaceService;

import com.kulpekin.models.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);
    void updateClient(Client client);
    Client getClientById(int id);
    void removeClient(int id);
    List<Client> listClients();
}
