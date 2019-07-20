package com.kulpekin.service.implementation;

import com.kulpekin.models.Client;
import com.kulpekin.service.interfaceService.ClientService;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientServiceImplTest {

    @Autowired
    private ClientService clientService;

    private Client expectedClient;

    @Before
    public void setUp(){
        expectedClient = new Client();
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("380631060526");
        expectedClient.setEmail("kulpekin@gmail.com");
        clientService.addClient(expectedClient);
    }


    @Test
    public void addClientTest() {
        Client resultClient = clientService.getClientById(expectedClient.getId());
        assertEquals(expectedClient,resultClient);
    }

    @Test
    public void updateClientTest() {
        Client resultClient = new Client();

        resultClient.setFirstName("Ihor");
        resultClient.setLastName("Kulpekin");
        resultClient.setMobileNumber("380631060527");
        resultClient.setEmail("kulpekin20@gmial.com");
        clientService.addClient(resultClient);
        resultClient.setFirstName("Sasha");
        clientService.updateClient(resultClient);
        assertEquals(clientService.getClientById(resultClient.getId()).getFirstName(),"Sasha");
    }

    @Test
    public void getClientByIdTest() {
        List<Client> clientList = clientService.listClients();
        Client clientFromList = clientList.get(0);
        Client clientGotById = clientService.getClientById(clientFromList.getId());
        assertNotNull(clientGotById);
    }

    @Test
    public void removeClientTest() {
        clientService.removeClient(expectedClient.getId());
        assertEquals(0L,clientService.listClients().size());
    }

    @Test
    public void listClientsTest() {
        assertEquals(1L,clientService.listClients().size());
    }
}