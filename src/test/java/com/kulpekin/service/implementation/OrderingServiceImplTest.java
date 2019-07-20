package com.kulpekin.service.implementation;

import com.kulpekin.models.Ordering;
import com.kulpekin.service.interfaceService.OrderingService;
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
public class OrderingServiceImplTest {

    @Autowired
    private OrderingService orderingService;

    private Ordering expectedOrdering;

    @Before
    public void setUp(){
        expectedOrdering = new Ordering();
        expectedOrdering.setDateOrdering("20-11-1999");
        expectedOrdering.setGeneralPrice("2500");
        expectedOrdering.setNumberService("2000");
        expectedOrdering.setIdWorker(1);
        expectedOrdering.setIdClient(2);
        expectedOrdering.setIdNameService(5);
        orderingService.addOrdering(expectedOrdering);
    }

    @Test
    public void addOrderingTest() {
        Ordering resultOrdering = orderingService.getOrderingById(expectedOrdering.getId());
        assertEquals(expectedOrdering,resultOrdering);
    }

    @Test
    public void updateOrderingTest() {
        expectedOrdering.setGeneralPrice("987115");
        orderingService.updateOrdering(expectedOrdering);
        assertEquals(orderingService.getOrderingById(expectedOrdering.getId()).getGeneralPrice(),"987115");
    }

    @Test
    public void getOrderingByIdTest() {
        List<Ordering> orderingList = orderingService.listOrderings();
        Ordering orderingFromList = orderingList.get(0);
        Ordering orderingGotById = orderingService.getOrderingById(orderingFromList.getId());
        assertNotNull(orderingGotById);
    }

    @Test
    public void removeOrderingTest() {
        int resultSizeListOrderings = orderingService.listOrderings().size()-1;
        orderingService.removeOrdering(expectedOrdering.getId());
        assertEquals(resultSizeListOrderings,orderingService.listOrderings().size());
    }

    @Test
    public void listOrderingsTest() {
        int resultSizeListOrderings = orderingService.listOrderings().size();
        assertEquals(orderingService.listOrderings().size(),resultSizeListOrderings);
    }

    @Test
    public void listNameServiceTest() {
        int resultSizeListNameService = orderingService.listNameService().size();
        assertEquals(orderingService.listNameService().size(),resultSizeListNameService);
    }

    @Test
    public void listClientsTest() {
        int resultSizeListClients = orderingService.listClients().size();
        assertEquals(orderingService.listClients().size(),resultSizeListClients);
    }

    @Test
    public void listWorkersTest() {
        int resultSizeListWorkers = orderingService.listWorkers().size();
        assertEquals(orderingService.listWorkers().size(),resultSizeListWorkers);
    }

}