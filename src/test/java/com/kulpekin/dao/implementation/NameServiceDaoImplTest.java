package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.NameServiceDao;
import com.kulpekin.models.NameService;
import java.util.List;

import com.kulpekin.models.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NameServiceDaoImplTest {

    @Autowired
    private NameServiceDao nameServiceDao;


    private NameService expectedNameService;


    @Before
    public void setUp(){
        expectedNameService = new NameService();
        expectedNameService.setKindService("kiraku");
        expectedNameService.setNameService("kur");
        expectedNameService.setPrice(4.5);
    }


    @Transactional
    @Rollback
    @Test
    public void insertNameServiceTest() {
        nameServiceDao.insertNameService(expectedNameService);
        NameService resultNameService = nameServiceDao.getNameServiceById(expectedNameService.getId());
        assertNotNull(expectedNameService);
        assertNotNull(resultNameService);
        assertEquals(expectedNameService.getId(),resultNameService.getId());

    }

    @Transactional
    @Rollback
    @Test
    public void updateNameServiceTest() {
        NameService nameService = new NameService();
        nameService.setNameService("sh");
        nameService.setKindService("hy");
        nameService.setPrice(4.9);
        nameServiceDao.insertNameService(nameService);
        nameService.setNameService("shte");
        nameServiceDao.updateNameService(nameService);
        assertEquals(nameService.getNameService(),"shte");
    }

    @Transactional
    @Rollback
    @Test
    public void deleteNameServiceTest() {
        NameService nameService = new NameService();
        NameService nameService1 = new NameService();
        nameService.setNameService("sdas");
        nameService.setKindService("cvc");
        nameService.setPrice(6.5);
        nameService1.setNameService("sdas");
        nameService1.setKindService("casq");
        nameService1.setPrice(6.8);
        nameServiceDao.insertNameService(nameService);
        nameServiceDao.insertNameService(nameService1);
        assertEquals(2L,nameServiceDao.listNameServices().size());
        nameServiceDao.deleteNameService(nameService.getId());
        assertEquals(1L,nameServiceDao.listNameServices().size());
    }


    @Transactional
    @Rollback
    @Test
    public void getNameServiceByIdTest() {
        NameService nameService = new NameService();
        NameService nameService1 = new NameService();
        nameService.setNameService("sdas");
        nameService.setKindService("cvc");
        nameService.setPrice(6.5);
        nameService1.setNameService("sdas");
        nameService1.setKindService("casq");
        nameService1.setPrice(6.8);
        nameServiceDao.insertNameService(nameService);
        nameServiceDao.insertNameService(nameService1);
        List<NameService> nameServiceList = nameServiceDao.listNameServices();
        NameService nameService2 = nameServiceList.get(0);
        NameService nameService3 = nameServiceDao.getNameServiceById(nameService2.getId());
        assertNotNull(nameService3);
    }


    @Transactional
    @Rollback
    @Test
    public void listNameServicesTest() {
        NameService nameService = new NameService();
        nameService.setNameService("sdas");
        nameService.setKindService("cvc");
        nameService.setPrice(6.5);
        nameServiceDao.insertNameService(nameService);
        assertEquals(1L,nameServiceDao.listNameServices().size());
    }



    @Transactional
    @Rollback
    @Test
    public void listServicesTest() {
        assertEquals(0L,nameServiceDao.listServices().size());
    }

}