package com.kulpekin.service.implementation;

import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.WorkerService;
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
public class WorkerServiceImplTest {

    @Autowired
    private WorkerService workerService;


    private Worker expectedWorker;

    @Before
    public void setUp(){
        expectedWorker = new Worker();
        expectedWorker.setFirstName("Ihor");
        expectedWorker.setLastName("Kulpekin");
        expectedWorker.setPosition("sdasdas");
        workerService.addWorker(expectedWorker);
    }

    @Test
    public void addWorkerTest() {
        Worker resultWorker = workerService.getWorkerById(expectedWorker.getId());
        assertEquals(expectedWorker,resultWorker);
    }

    @Test
    public void updateWorkerTest() {
        Worker resultWorker = new Worker();

        resultWorker.setFirstName("Ihor");
        resultWorker.setLastName("Kulpekin");
        resultWorker.setPosition("manager");
        workerService.addWorker(resultWorker);
        resultWorker.setFirstName("Sasha");
        workerService.updateWorker(resultWorker);
        assertEquals(workerService.getWorkerById(resultWorker.getId()).getFirstName(),"Sasha");
    }

    @Test
    public void getWorkerByIdTest() {
        List<Worker> workerList = workerService.listWorkers();
        Worker workerFromList = workerList.get(0);
        Worker worker1GotById = workerService.getWorkerById(workerFromList.getId());
        assertNotNull(worker1GotById);
    }

    @Test
    public void removeWorkerTest() {
        workerService.removeWorker(expectedWorker.getId());
        assertEquals(0,workerService.listWorkers().size());
    }

    @Test
    public void listWorkersTest() {
        assertEquals(1,workerService.listWorkers().size());
    }

}