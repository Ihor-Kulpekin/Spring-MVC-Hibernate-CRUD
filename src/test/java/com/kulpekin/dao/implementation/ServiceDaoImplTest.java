package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.ServiceDao;
import com.kulpekin.models.Service;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceDaoImplTest {

    @Autowired
    private ServiceDao serviceDao;

    private Service expService;

    @Before
    public void setUp(){
        expService = new Service();
        expService.setName("cards");
    }

    @Test
    @Transactional
    @Rollback
    public void addServiceTest() {
        serviceDao.addService(expService);
        Service resultService = serviceDao.getServiceById(expService.getId());
        assertNotNull(expService);
        assertNotNull(resultService);
        Assert.assertEquals(expService.getId(),resultService.getId());
        Assert.assertEquals(expService.getName(),resultService.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void updateServiceTest() {
        expService.setName("cards");
        serviceDao.updateService(expService);
        assertEquals(serviceDao.getServiceById(expService.getId()).getName(),"cards");
    }

    @Test
    @Transactional
    @Rollback
    public void getServiceByIdTest() {
        Service service = new Service();
        Service service1 = new Service();
        service.setName("kik");
        service1.setName("kiki love me");
        serviceDao.addService(service);
        serviceDao.addService(service1);
        assertEquals(2L,serviceDao.listServices().size());
        List<Service> serviceList = serviceDao.listServices();
        Service service2 = serviceList.get(0);
        Service service3 = serviceDao.getServiceById(service2.getId());
        assertNotNull(service3);
    }

    @Test
    @Transactional
    @Rollback
    public void removeServiceTest() {
        Service service = new Service();
        Service service1 = new Service();
        service.setName("kik");
        service1.setName("kiki love me");
        serviceDao.addService(service);
        serviceDao.addService(service1);
        assertEquals(2L,serviceDao.listServices().size());
        serviceDao.removeService(service1.getId());
        assertEquals(1L,serviceDao.listServices().size());
    }

    @Test
    @Transactional
    @Rollback
    public void listServices() {
        assertEquals(0L,serviceDao.listServices().size());
    }
}