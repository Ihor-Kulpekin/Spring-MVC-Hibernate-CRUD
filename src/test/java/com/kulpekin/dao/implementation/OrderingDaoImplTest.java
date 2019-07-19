package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.OrderingDao;
import com.kulpekin.models.Ordering;
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
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderingDaoImplTest {

    @Autowired
    private OrderingDao orderingDao;

    private Ordering expectedOrdering, expectedOrdering1;


    @Before
    public void setUp(){
        expectedOrdering = new Ordering();
        expectedOrdering.setGeneralPrice("230");
        expectedOrdering.setDateOrdering("20-11-1999");
        expectedOrdering.setNumberService("2000");
        expectedOrdering.setIdClient(1);
        expectedOrdering.setIdNameService(3);
        expectedOrdering.setIdWorker(2);


        expectedOrdering1 = new Ordering();
        expectedOrdering1.setGeneralPrice("230");
        expectedOrdering1.setDateOrdering("20-11-1999");
        expectedOrdering1.setNumberService("2000");
        expectedOrdering1.setIdClient(1);
        expectedOrdering1.setIdNameService(3);
        expectedOrdering1.setIdWorker(2);
    }

    @Transactional
    @Rollback
    @Test
    public void addOrderingTest() {
        orderingDao.addOrdering(expectedOrdering);
        Ordering resultOrdering = orderingDao.getOrderingById(expectedOrdering.getId());
        assertNotNull(expectedOrdering);
        assertNotNull(resultOrdering);

        assertEquals(expectedOrdering,resultOrdering);
    }

    @Transactional
    @Rollback
    @Test
    public void updateOrderingTest() {
        orderingDao.addOrdering(expectedOrdering);
        expectedOrdering.setGeneralPrice("987115");
        orderingDao.updateOrdering(expectedOrdering);
        assertEquals(orderingDao.getOrderingById(expectedOrdering.getId()).getGeneralPrice(),"987115");
    }

    @Transactional
    @Rollback
    @Test
    public void getOrderingByIdTest() {
        orderingDao.addOrdering(expectedOrdering);
        orderingDao.addOrdering(expectedOrdering1);
        List<Ordering> orderingList = orderingDao.listOrderings();
        Ordering resultOrdering = orderingList.get(0);
        Ordering resultOrderingById = orderingDao.getOrderingById(resultOrdering.getId());
        assertNotNull(resultOrderingById);
    }

    @Transactional
    @Rollback
    @Test
    public void removeOrderingTest() {
        orderingDao.addOrdering(expectedOrdering);
        orderingDao.addOrdering(expectedOrdering1);
        assertEquals(2L,orderingDao.listOrderings().size());
        orderingDao.removeOrdering(expectedOrdering1.getId());
        assertEquals(1L,orderingDao.listOrderings().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listOrderingsTest() {
        assertEquals(0L,orderingDao.listOrderings().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listNameServiceTest() {
        assertEquals(0L,orderingDao.listNameService().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listClientsTest() {
        assertEquals(0L,orderingDao.listClients().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listWorkersTest() {
        assertEquals(0L,orderingDao.listWorkers().size());
    }

}