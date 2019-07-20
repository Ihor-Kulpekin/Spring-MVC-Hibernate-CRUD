package com.kulpekin.dao.implementation;

import com.kulpekin.dao.interfaceDao.WorkerDao;
import com.kulpekin.models.Worker;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkerDaoImplTest {

    @Autowired
    private WorkerDao workerDao;

    private Worker expectedWorker;

    @Before
    public void setUp() {
        expectedWorker = new Worker();
        expectedWorker.setFirstName("Ihor");
        expectedWorker.setLastName("Kulpekin");
        expectedWorker.setPosition("manager");
    }

    @Transactional
    @Rollback
    @Test
    public void addWorkerTest() {
        workerDao.addWorker(expectedWorker);
        Worker resultWorker = workerDao.getWorkerById(expectedWorker.getId());
        Assert.assertNotNull(expectedWorker);
        Assert.assertNotNull(resultWorker);
        assertEquals(expectedWorker,resultWorker);
    }

    @Transactional
    @Rollback
    @Test
    public void updateWorkerTest() {
        Worker resultWorker = new Worker();

        resultWorker.setFirstName("Ihor");
        resultWorker.setLastName("Kulpekin");
        resultWorker.setPosition("manager");
        workerDao.addWorker(resultWorker);
        resultWorker.setFirstName("Sasha");
        workerDao.updateWorker(resultWorker);
        assertEquals(workerDao.getWorkerById(resultWorker.getId()).getFirstName(),"Sasha");
    }

    @Transactional
    @Rollback
    @Test
    public void getWorkerByIdTest() {
        Worker resultWorker = new Worker();
        Worker resultWorker1 = new Worker();
        resultWorker.setFirstName("Ihor");
        resultWorker.setLastName("Kulpekin");
        resultWorker.setPosition("manager");
        resultWorker1.setFirstName("Sasha");
        resultWorker1.setLastName("Kulpekin");
        resultWorker1.setPosition("manager");
        workerDao.addWorker(resultWorker);
        workerDao.addWorker(resultWorker1);
        List<Worker> workerList = workerDao.listWorkers();
        Worker worker = workerList.get(0);
        Worker worker1 = workerDao.getWorkerById(worker.getId());
        assertNotNull(worker1);
    }

    @Transactional
    @Rollback
    @Test
    public void removeWorkerTest() {
        Worker resultWorker = new Worker();
        Worker resultWorker1 = new Worker();
        resultWorker.setFirstName("Ihor");
        resultWorker.setLastName("Kulpekin");
        resultWorker.setPosition("manager");
        resultWorker1.setFirstName("Sasha");
        resultWorker1.setLastName("Kulpekin");
        resultWorker1.setPosition("manager");
        workerDao.addWorker(resultWorker);
        workerDao.addWorker(resultWorker1);
        List<Worker> workerList = workerDao.listWorkers();
        workerDao.removeWorker(workerList.get(0).getId());
        assertEquals(1L,workerDao.listWorkers().size());
    }

    @Transactional
    @Rollback
    @Test
    public void listWorkersTest() {
        assertEquals(0L,workerDao.listWorkers().size());
    }
}