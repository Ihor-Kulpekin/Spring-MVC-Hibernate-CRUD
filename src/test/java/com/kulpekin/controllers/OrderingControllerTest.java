package com.kulpekin.controllers;
import com.kulpekin.models.Client;
import com.kulpekin.models.Ordering;
import com.kulpekin.service.interfaceService.ClientService;

import java.util.ArrayList;
import java.util.List;

import com.kulpekin.service.interfaceService.OrderingService;
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
public class OrderingControllerTest {

    @InjectMocks
    private OrderingController orderingController;

    @Mock
    private OrderingService orderingService;

    @Mock
    private View mockView;

    private MockMvc mockMvc;

    private Ordering expectedOrdering;

    @Before
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(orderingController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    public void showPAgeListOrdering() throws Exception {
        String url = "/listOrdering";
        List<Ordering> orderingList = new ArrayList<>();
        orderingList.add(expectedOrdering);
        when(orderingService.listOrderings()).thenReturn(orderingList);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attribute("ordering",orderingList.get(0)))
                .andExpect(view().name("ordering/listOrdering"));
    }

    @Test
    public void showPageAddOrderingTest() throws Exception {
        String url = "/new_Ordering";
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name("ordering/new_ordering"));
    }

    @Test
    public void addOrderingTest() throws Exception {
        String url = "/save_ordering";
        expectedOrdering = new Ordering(1,"2500","20-11-1999","2500",2,1,3);
        doNothing().when(orderingService).addOrdering(expectedOrdering);
        mockMvc.perform(post(url)
                .param("id","1")
                .param("generalPrice","2500")
                .param("dateOrdering","20-11-1999")
                .param("numberService","2500")
                .param("idClient","2")
                .param("idWorker","1")
                .param("idNameService","3"))
                .andExpect(status().isOk())
                .andExpect(view().name("redirect:/listOrdering"))
                .andExpect(model().attribute("ordering",instanceOf(Ordering.class)))
                .andExpect(model().attribute("ordering",hasProperty("id")))
                .andExpect(model().attribute("ordering",hasProperty("generalPrice")))
                .andExpect(model().attribute("ordering",hasProperty("dateOrdering")))
                .andExpect(model().attribute("ordering",hasProperty("numberService")))
                .andExpect(model().attribute("ordering",hasProperty("idClient")))
                .andExpect(model().attribute("ordering",hasProperty("idWorker")))
                .andExpect(model().attribute("ordering",hasProperty("idNameService")));
        ArgumentCaptor<Ordering> bountOrdering = ArgumentCaptor.forClass(Ordering.class);
        verify(orderingService).addOrdering(bountOrdering.capture());
        assertEquals(expectedOrdering.getId(),bountOrdering.getValue().getId());
    }

    @Test
    public void showPageEditOrderingTest() throws Exception {
        String url = "/edit_ordering/1";
        expectedOrdering = new Ordering(1,"2500","20-11-1999","2500",2,1,3);
        when(orderingService.getOrderingById(expectedOrdering.getId())).thenReturn(expectedOrdering);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attribute("ordering",expectedOrdering))
                .andExpect(view().name("ordering/edit_ordering"));
    }

    @Test
    public void editOrdering() throws Exception {
     String url = "/edit_ordering/ordering";
     expectedOrdering = new Ordering(1,"2500","20-11-1999","2500",2,1,3);
     MvcResult mvcResult = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(expectedOrdering.toString())).andReturn();

     int status= mvcResult.getResponse().getStatus();
     assertEquals(200,status);
    }

    @Test
    public void deleteOrdering() throws Exception {
        String url = "/delete_ordering/1";
        expectedOrdering = new Ordering(1,"2500","20-11-1999","2500",2,1,3);
        doNothing().when(orderingService).addOrdering(expectedOrdering);
        mockMvc.perform(get(url)).andExpect(status().isOk())
                .andExpect(view().name("redirect:/listOrdering"));
        verify(orderingService,times(1)).removeOrdering(expectedOrdering.getId());
    }

    @Test
    public void detailsOrdering() throws Exception {
        String url = "/search_ordering/1";
        expectedOrdering = new Ordering(1,"2500","20-11-1999","2500",2,1,3);
        when(orderingService.getOrderingById(expectedOrdering.getId())).thenReturn(expectedOrdering);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andReturn();
        System.out.println(expectedOrdering.toString());
        int resultStatus = mvcResult.getResponse().getStatus();
        assertEquals(200,resultStatus);
    }
}