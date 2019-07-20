package com.kulpekin.service.implementation;

import com.kulpekin.models.NameService;
import com.kulpekin.service.interfaceService.NamePoslugaService;
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
public class NamePoslugaServiceImplTest {

    @Autowired
    private NamePoslugaService namePoslugaService;

    private NameService expectedNameService;


    @Before
    public void setUp() {
        expectedNameService = new NameService();
        expectedNameService.setNameService("sdas");
        expectedNameService.setKindService("as");
        expectedNameService.setPrice(4.6);
        namePoslugaService.insertNameService(expectedNameService);
    }

    @Test
    public void insertNameServiceTest() {
        NameService resultNameService = namePoslugaService.getNameServiceById(expectedNameService.getId());
        assertEquals(expectedNameService,resultNameService);
    }

    @Test
    public void updateNameServiceTest() {
        NameService resultNameService = new NameService();
        resultNameService.setPrice(expectedNameService.getPrice());
        resultNameService.setNameService(expectedNameService.getNameService());
        resultNameService.setKindService("Flaera");
        namePoslugaService.insertNameService(resultNameService);
        resultNameService.setNameService("Flaera A4");
        namePoslugaService.updateNameService(resultNameService);
        assertNotEquals(expectedNameService.getNameService(),resultNameService.getNameService());
    }

    @Test
    public void deleteNameServiceTest() {
        namePoslugaService.deleteNameService(expectedNameService.getId());
        assertEquals(0L,namePoslugaService.listNameServices().size());
    }

    @Test
    public void getNameServiceByIdTest() {
        List<NameService> serviceList = namePoslugaService.listNameServices();
        NameService nameServiceFromList = serviceList.get(0);
        NameService serviceGotById = namePoslugaService.getNameServiceById(nameServiceFromList.getId());
        assertNotNull(serviceGotById);
    }

    @Test
    public void listNameServicesTest() {
        assertEquals(1L,namePoslugaService.listNameServices().size());
    }

    @Test
    public void listServicesTest() {
        assertEquals(0L,namePoslugaService.listServices().size());
    }
}