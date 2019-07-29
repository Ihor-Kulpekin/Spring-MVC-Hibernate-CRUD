package com.kulpekin.controllers;

import com.kulpekin.models.NameService;
import com.kulpekin.service.interfaceService.NamePoslugaService;
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

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.beans.HasProperty.hasProperty;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class NameServiceControllerTest {

    @InjectMocks
    private NameServiceController nameServiceController;

    @Mock
    private NamePoslugaService namePoslugaService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    private NameService expectedNameService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(nameServiceController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void showPageListNameService() throws Exception {
        String url = "/listNameService";
        List<NameService> expectedList = new ArrayList<>();
        expectedList.add(expectedNameService);
        when(namePoslugaService.listNameServices()).thenReturn(expectedList);
        MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attribute("nameService",expectedList.get(0)))
                .andExpect(view().name("nameService/listNameService"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void showPageNewNameService() throws Exception {
        String urlStatus = "/new_nameService";
        MvcResult mvcResult = mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(view().name("nameService/new_nameservice"))
                .andReturn();
        int statusCode = mvcResult.getResponse().getStatus();
        assertEquals(200,statusCode);
    }

    @Test
    public void addNameService() throws Exception {
        String url = "/saveNameService";
        int id = 1;
        NameService resultNameService = new NameService();
        resultNameService.setId(id);
        resultNameService.setNameService("dasdas");
        resultNameService.setKindService("dsadas");
        resultNameService.setPrice(12.5);
        doNothing().when(namePoslugaService).insertNameService(resultNameService);
        mockMvc.perform(post(url)
                .param("id","1")
                .param("name","dsd"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listNameService"))
                .andExpect(model().attribute("nameService",instanceOf(NameService.class)))
                .andExpect(model().attribute("nameService",hasProperty("id")))
                .andExpect(model().attribute("nameService",hasProperty("nameService")))
                .andExpect(model().attribute("nameService",hasProperty("kindService")))
                .andExpect(model().attribute("nameService",hasProperty("price")));

        ArgumentCaptor<NameService> boundNameService = ArgumentCaptor.forClass(NameService.class);
        verify(namePoslugaService).insertNameService(boundNameService.capture());
        assertEquals(id,boundNameService.getValue().getId());
    }

    @Test
    public void showPageEditNameService() throws Exception {
        String urlStatus = "/edit_nameservice/1";
        int id = 1;
        NameService resultNameService = new NameService();
        resultNameService.setId(id);
        resultNameService.setNameService("dasdas");
        resultNameService.setKindService("dsadas");
        resultNameService.setPrice(12.5);
        when(namePoslugaService.getNameServiceById(id)).thenReturn(resultNameService);
        mockMvc.perform(get(urlStatus))
                .andExpect(status().isOk())
                .andExpect(model().attribute("nameService",resultNameService))
                .andExpect(view().name("nameService/edit_nameservice"));
    }

    @Test
    public void editNameService() throws Exception {
        String url = "/edit_nameservice/nameservice";
        int id = 1;
        NameService resultNameService = new NameService();
        resultNameService.setId(id);
        resultNameService.setNameService("dasdas");
        resultNameService.setKindService("dsadas");
        resultNameService.setPrice(12.5);

        MvcResult mvcResult = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(resultNameService.toString())).andReturn();

        int status= mvcResult.getResponse().getStatus();
        assertEquals(200,status);
    }

    @Test
    public void deleteNameService() throws Exception {
        int id = 1;
        NameService resultNameService = new NameService();
        resultNameService.setId(id);
        resultNameService.setNameService("dasdas");
        resultNameService.setKindService("dsadas");
        resultNameService.setPrice(12.5);
        String urlPage = "/delete_nameservice/1";
        doNothing().when(namePoslugaService).insertNameService(resultNameService);
        mockMvc.perform(get(urlPage))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listNameService"));
        verify(namePoslugaService,times(1)).deleteNameService(id);
    }

    @Test
    public void detailsNameService() throws Exception {
        String url = "/search_nameservice/1";
        int id = 1;
        NameService resultNameService = new NameService();
        resultNameService.setId(id);
        resultNameService.setNameService("dasdas");
        resultNameService.setKindService("dsadas");
        resultNameService.setPrice(12.5);
        when(namePoslugaService.getNameServiceById(id)).thenReturn(resultNameService);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        System.out.println(resultNameService.toString());
        int resultStatus = mvcResult.getResponse().getStatus();
        assertEquals(200,resultStatus);
        verify(namePoslugaService,times(1)).getNameServiceById(id);
    }
}