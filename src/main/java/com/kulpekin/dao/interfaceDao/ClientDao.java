package com.kulpekin.dao.interfaceDao;

import com.kulpekin.models.Client;

import java.util.List;

public interface ClientDao {
    void addClient(Client client);
    void updateClient(Client client);
    Client getClientById(int id);
    void removeClient(int id);
    List<Client> listClients();
}
