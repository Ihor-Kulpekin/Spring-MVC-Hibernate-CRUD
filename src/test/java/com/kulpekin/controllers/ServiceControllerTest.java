package com.kulpekin.controllers;

import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.PoslugaService;
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

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceControllerTest {

    @InjectMocks
    private ServiceController serviceController;

    @Mock
    private PoslugaService poslugaService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    private Service expectedService;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(serviceController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void homeTest() throws Exception {
        String urlStatus = "/index";
        List<Service> expectedList = new ArrayList<>();
        expectedList.add(expectedService);
        when(poslugaService.listServices()).thenReturn(expectedList);
         mockMvc.perform(get(urlStatus))
                 .andExpect(status().isOk())
                 .andExpect(model().attribute("service",expectedList.get(0)))
                 .andExpect(view().name("service/index"));
    }

    @Test
    public void newServiceFormTest() throws Exception {
        String urlStatus = "/new";
        mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(view().name("service/new_service"));
    }

    @Test
    public void saveServiceTest() throws Exception {
        String url = "/save";
        int id = 1;
        Service resultService = new Service();
        resultService.setId(id);
        resultService.setName("dsd");
        doNothing().when(poslugaService).addService(resultService);
        mockMvc.perform(post(url)
                .param("id","1")
                .param("name","dsd"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/index"))
                .andExpect(model().attribute("service",instanceOf(Service.class)))
                .andExpect(model().attribute("service",hasProperty("id")))
                .andExpect(model().attribute("service",hasProperty("name")));
        ArgumentCaptor<Service> boundService = ArgumentCaptor.forClass(Service.class);
        verify(poslugaService).addService(boundService.capture());
        assertEquals(id,boundService.getValue().getId());
    }

    @Test
    public void editServiceFormTest() throws Exception {
        String urlStatus = "/edit/1";
        int id = 1;
        Service resultService = new Service();
        resultService.setId(id);
        resultService.setName("dsd");
        when(poslugaService.getServiceById(id)).thenReturn(resultService);
        mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(model().attribute("service",resultService))
                .andExpect(view().name("service/edit_service"));
    }

    @Test
    public void editServiceTest() throws Exception {
        int id = 1;
        Service resultService = new Service();
        resultService.setId(id);
        resultService.setName("dsd");
        MvcResult mvcResult = mockMvc.perform(post("/edit/service")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(resultService.toString())).andReturn();

        int status= mvcResult.getResponse().getStatus();
        assertEquals(200,status);

    }

    @Test
    public void deleteServiceTest() throws Exception {
        int id = 1;
        Service resultService = new Service();
        resultService.setId(id);
        resultService.setName("dsd");
        doNothing().when(poslugaService).addService(resultService);
        mockMvc.perform(get("/delete/1")).andExpect(status().isOk())
                .andExpect(view().name("redirect:/index"));
        verify(poslugaService,times(1)).removeService(id);
    }

    @Test
    public void detailsServiceTest() throws Exception {
        String url = "/search/1";
        Service resultService = new Service();
        resultService.setId(1);
        resultService.setName("dsd");
        when(poslugaService.getServiceById(1)).thenReturn(resultService);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
         MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        System.out.println(resultService.toString());
        int resultStatus = mvcResult.getResponse().getStatus();
         assertEquals(200,resultStatus);
    }
}