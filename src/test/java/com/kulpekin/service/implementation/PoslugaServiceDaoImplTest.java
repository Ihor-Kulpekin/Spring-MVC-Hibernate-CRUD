package com.kulpekin.service.implementation;

import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.PoslugaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PoslugaServiceDaoImplTest {

    @Autowired
    private PoslugaService poslugaService;

    private Service expectedService;

    @Before
    public void setUp(){
        expectedService = new Service();
        expectedService.setName("Calendari");
        poslugaService.addService(expectedService);
    }

    @Test
    public void addServiceTest() {
        Service resultService = poslugaService.getServiceById(expectedService.getId());
        assertEquals(expectedService,resultService);
    }

    @Test
    public void updateServiceTest() {
        Service resultService = new Service();
        resultService.setName(expectedService.getName());
        poslugaService.addService(resultService);
        resultService.setName("Flaera A4");
        poslugaService.updateService(resultService);
        System.out.println(resultService.getName());
        assertNotEquals(expectedService.getName(),resultService.getName());
    }

    @Test
    public void getServiceByIdTest() {
        List<Service> serviceList = poslugaService.listServices();
        Service serviceFromList = serviceList.get(0);
        Service serviceGettedById = poslugaService.getServiceById(serviceFromList.getId());
        assertNotNull(serviceGettedById);
    }

    @Test
    public void removeServiceTest() {
        poslugaService.removeService(expectedService.getId());
        assertEquals(0L,poslugaService.listServices().size());
    }

    @Test
    public void listServicesTest() {
        assertEquals(1L,poslugaService.listServices().size());
    }
}