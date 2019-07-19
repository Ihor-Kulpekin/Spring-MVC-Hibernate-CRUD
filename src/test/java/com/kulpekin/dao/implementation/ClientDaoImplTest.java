package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.ClientDao;
import com.kulpekin.models.Client;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientDaoImplTest {

    @Autowired
    private ClientDao clientDao;

    private Client resultClient;

    @Before
    public void setUp() {
        resultClient = new Client();
        resultClient.setFirstName("Ihor");
        resultClient.setLastName("Kulpekin");
        resultClient.setMobileNumber("380631060526");
        resultClient.setEmail("kulpekin20@gmial.com");
    }

    @Transactional
    @Rollback
    @Test
    public void addClientTest() {
        clientDao.addClient(resultClient);
        Client resultClient = clientDao.getClientById(this.resultClient.getId());
        assertNotNull(this.resultClient);
        assertNotNull(resultClient);
        assertEquals(this.resultClient,resultClient);
    }

    @Transactional
    @Rollback
    @Test
    public void updateClientTest() {
        Client resultClient = new Client();

        resultClient.setFirstName("Ihor");
        resultClient.setLastName("Kulpekin");
        resultClient.setMobileNumber("380631060526");
        resultClient.setEmail("kulpekin20@gmial.com");
        clientDao.addClient(resultClient);
        resultClient.setFirstName("Sasha");
        clientDao.updateClient(resultClient);
        assertEquals(clientDao.getClientById(resultClient.getId()).getFirstName(),"Sasha");
    }

    @Transactional
    @Rollback
    @Test
    public void getClientByIdTest() {
        Client client = new Client();
        Client client1 = new Client();
        client.setFirstName("Ihor");
        client.setLastName("Kulpa");
        client.setEmail("aaa@gmail.com");
        client.setMobileNumber("3814545145");
        client1.setFirstName("Ihor");
        client1.setLastName("Kulpa");
        client1.setEmail("aaaa@gmail.com");
        client1.setMobileNumber("38145451453");
        clientDao.addClient(client);
        clientDao.addClient(client1);
        List<Client> clientList = clientDao.listClients();
        Client client2 = clientList.get(0);
        Client client3 = clientDao.getClientById(client2.getId());
        assertNotNull(client3);
    }

    @Transactional
    @Rollback
    @Test
    public void removeClientTest() {
        Client client = new Client();
        Client client1 = new Client();
        client.setFirstName("Ihor");
        client.setLastName("Kulpa");
        client.setEmail("aaa@gmail.com");
        client.setMobileNumber("3814545145");
        client1.setFirstName("Ihor");
        client1.setLastName("Kulpa");
        client1.setEmail("aaaa@gmail.com");
        client1.setMobileNumber("38145451453");
        clientDao.addClient(client);
        clientDao.addClient(client1);
        clientDao.removeClient(client1.getId());
        assertEquals(1L,clientDao.listClients().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listClientsTest() {
        assertEquals(0L,clientDao.listClients().size());
    }
}
