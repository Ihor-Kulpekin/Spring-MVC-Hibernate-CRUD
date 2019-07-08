package com.kulpekin.service.implementation;

import com.kulpekin.dao.interfaceDao.ClientDao;
import com.kulpekin.models.Client;
import com.kulpekin.service.interfaceService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {


    private ClientDao clientDao;

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    @Override
    @Transactional
    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    @Transactional
    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }

    @Override
    @Transactional
    public void removeClient(int id) {
        clientDao.removeClient(id);
    }

    @Override
    @Transactional
    public List<Client> listClients() {
        return clientDao.listClients();
    }
}
