package com.kulpekin.controllers;

import com.kulpekin.models.Client;
import com.kulpekin.service.interfaceService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {


    private ClientService clientService;


    @Autowired
    @Qualifier("clientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/listClients")
    public ModelAndView showPageListClients(){
        ModelAndView modelAndView = new ModelAndView("client/listClients");
        List<Client> clientList = clientService.listClients();
        modelAndView.addObject("listClients",clientList);
        return modelAndView;
    }

    @RequestMapping("/new_client")
    public String showPageNewClient(Model model){
        model.addAttribute("client",new Client());
        return "client/new_client";
    }

    @RequestMapping(value = "/saveClient",method = RequestMethod.POST)
    public String addNewClient(@ModelAttribute("client") Client client){
        clientService.addClient(client);
        return "redirect:/listClients";
    }

    @RequestMapping("/edit_client")
    public ModelAndView showPageEditClient(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("client/edit_client");
        Client client = clientService.getClientById(id);
        modelAndView.addObject("client",client);
        return modelAndView;
    }

    @RequestMapping(value = "/edit_client/client",method = RequestMethod.POST)
    public String editClient(@ModelAttribute("client") Client client){
        clientService.updateClient(client);
        return "redirect:/listClients";
    }

    @RequestMapping("delete_client")
    public String deleteClient(@RequestParam int id){
        clientService.removeClient(id);
        return "redirect:/listClients";
    }


    @RequestMapping("/search_client")
    public ModelAndView detailsWorker(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("client/details_client");
        Client client = clientService.getClientById(id);
        modelAndView.addObject("client",client);
        return modelAndView;
    }

}
