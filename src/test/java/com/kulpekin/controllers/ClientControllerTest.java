package com.kulpekin.controllers;

import com.kulpekin.models.Client;
import com.kulpekin.service.interfaceService.ClientService;

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

import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Rollback
@Transactional
@ContextConfiguration(locations = "classpath:dispatcherServletTest-servlet.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    private Client expectedClient;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(clientController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void showPageListClients() throws Exception {
        String url = "/listClients";

        List<Client> clientList = new ArrayList<>();
        clientList.add(expectedClient);
        when(clientService.listClients()).thenReturn(clientList);
       MvcResult mvcResult =  mockMvc.perform(get(url))
               .andExpect(status().isOk())
               .andExpect(model().attribute("client",clientList.get(0)))
               .andExpect(view().name("client/listClients"))
               .andReturn();
       int statusCode = mvcResult.getResponse().getStatus();
       assertEquals(200,statusCode);
    }

    @Test
    public void showPageNewClient() throws Exception {
        String url = "/new_client";
        expectedClient = new Client();
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("client/new_client"))
                .andReturn();
        int statusCode = mvcResult.getResponse().getStatus();
        assertEquals(200,statusCode);
    }

    @Test
    public void addNewClient() throws Exception {
        String url = "/saveClient";
        expectedClient = new Client();
        expectedClient.setId(1);
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        doNothing().when(clientService).addClient(expectedClient);
        mockMvc.perform(post(url)
        .param("id","1")
        .param("firstName","Ihor")
        .param("lastName","Kulpekin")
        .param("mobileNumber","380631060526")
        .param("email","kulpekin20@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listClients"))
                .andExpect(model().attribute("client",instanceOf(Client.class)))
                .andExpect(model().attribute("client",hasProperty("id")))
                .andExpect(model().attribute("client",hasProperty("firstName")))
                .andExpect(model().attribute("client",hasProperty("lastName")))
                .andExpect(model().attribute("client",hasProperty("mobileNumber")))
                .andExpect(model().attribute("client",hasProperty("email")));
        ArgumentCaptor<Client> boundClient = ArgumentCaptor.forClass(Client.class);
        verify(clientService).addClient(boundClient.capture());
        assertEquals(expectedClient.getId(),boundClient.getValue().getId());

    }

    @Test
    public void showPageEditClient() throws Exception {
        String url = "/edit_client/1";
        expectedClient = new Client();
        expectedClient.setId(1);
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        when(clientService.getClientById(expectedClient.getId())).thenReturn(expectedClient);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("client/edit_client"))
                .andExpect(model().attribute("client",expectedClient));
    }

    @Test
    public void editClient() throws Exception {
        String url = "/edit_client/client";
        expectedClient = new Client();
        expectedClient.setId(1);
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        MvcResult mvcResult = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(expectedClient.toString()))
                .andReturn();
        int statusCode = mvcResult.getResponse().getStatus();
        assertEquals(200,statusCode);
    }

    @Test
    public void deleteClient() throws Exception {
        String url = "/delete_client/1";
        expectedClient = new Client();
        expectedClient.setId(1);
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        doNothing().when(clientService).addClient(expectedClient);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listClients"));
        verify(clientService,times(1)).removeClient(expectedClient.getId());
    }

    @Test
    public void detailsWorker() throws Exception {
        String url = "/search_client/1";
        expectedClient = new Client();
        expectedClient.setId(1);
        expectedClient.setFirstName("Ihor");
        expectedClient.setLastName("Kulpekin");
        expectedClient.setMobileNumber("+380631060526");
        expectedClient.setEmail("kulpekin20@gmail.com");
        when(clientService.getClientById(expectedClient.getId())).thenReturn(expectedClient);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        int resultStatus = mvcResult.getResponse().getStatus();
        assertEquals(200,resultStatus);
    }
}