package com.kulpekin.controllers;

import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.WorkerService;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.View;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class WorkerControllerTest {

    @InjectMocks
    private WorkerController workerController;

    @Mock
    private WorkerService workerService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    private Worker expectedWorker;

    private String url;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(workerController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void showWorkerPage() throws Exception {
        url = "/listWorkers";
        List<Worker> workerList = new ArrayList<>();
        workerList.add(expectedWorker);
        when(workerService.listWorkers()).thenReturn(workerList);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attribute("service",workerList.get(0)))
                .andExpect(view().name("worker/listWorkers"));
    }

    @Test
    public void newWorkerForm() throws Exception {
        String urlStatus = "/newWorker";
        mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(view().name("worker/new_worker"));
    }

    @Test
    public void saveWorker() throws Exception {
        String url = "/saveWorker";
        int id = 1;
        Worker resultWorker = new Worker();
        resultWorker.setId(id);
        resultWorker.setFirstName("Vasya");
        resultWorker.setLastName("Tuchkovskiy");
        resultWorker.setPosition("developer");
        doNothing().when(workerService).addWorker(resultWorker);
        mockMvc.perform(post(url)
        .param("id","1")
        .param("firstName","Vasya")
        .param("lastName","Tuchkovskiy").param("position","developer"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listWorkers"))
                .andExpect(model().attribute("worker",instanceOf(Worker.class)))
                .andExpect(model().attribute("worker",hasProperty("id")))
                .andExpect(model().attribute("worker",hasProperty("firstName")))
                .andExpect(model().attribute("worker",hasProperty("lastName")))
                .andExpect(model().attribute("worker",hasProperty("position")));
        ArgumentCaptor<Worker> boundWorker = ArgumentCaptor.forClass(Worker.class);
        verify(workerService).addWorker(boundWorker.capture());
        assertEquals(id,boundWorker.getValue().getId());
    }

    @Test
    public void showPageEditWorker() throws Exception {
        String urlStatus = "/edit_worker/1";
        int id = 1;
        Worker resultWorker = new Worker();
        resultWorker.setId(id);
        resultWorker.setFirstName("Vasya");
        resultWorker.setLastName("Tuchkovskiy");
        resultWorker.setPosition("developer");
        when(workerService.getWorkerById(id)).thenReturn(resultWorker);
        mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(model().attribute("worker",resultWorker))
                .andExpect(view().name("worker/edit_worker"));
    }

    @Test
    public void editWorker() throws Exception {
        String url = "/edit_worker/worker";
        int id = 1;
        Worker resultWorker = new Worker();
        resultWorker.setId(id);
        resultWorker.setFirstName("Vasya");
        resultWorker.setLastName("Tuchkovskiy");
        resultWorker.setPosition("developer");
        MvcResult mvcResult = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(resultWorker.toString())).andReturn();

        int status= mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void deleteWorker() throws Exception {
        int id = 1;
        Worker resultWorker = new Worker();
        resultWorker.setId(id);
        resultWorker.setFirstName("Vasya");
        resultWorker.setLastName("Tuchkovskiy");
        resultWorker.setPosition("developer");
        doNothing().when(workerService).addWorker(resultWorker);
        mockMvc.perform(get("/delete_worker/1")).andExpect(status().isOk())
                .andExpect(view().name("redirect:/listWorkers"));
        verify(workerService,times(1)).removeWorker(id);
    }

    @Test
    public void detailsWorker() throws Exception {
        url = "/search_worker/1";
        int id = 1;
        Worker resultWorker = new Worker();
        resultWorker.setId(id);
        resultWorker.setFirstName("Vasya");
        resultWorker.setLastName("Tuchkovskiy");
        resultWorker.setPosition("developer");
        when(workerService.getWorkerById(id)).thenReturn(resultWorker);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        System.out.println(resultWorker.toString());
        int resultStatus = mvcResult.getResponse().getStatus();
        assertEquals(200,resultStatus);
    }
}