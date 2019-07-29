package com.kulpekin.controllers;

import com.kulpekin.models.Client;
import com.kulpekin.service.interfaceService.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ClientController {


    private ClientService clientService;

    private final Logger logger = Logger.getLogger(ClientController.class);

    @Autowired
    @Qualifier("clientService")
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/listClients")
    public ModelAndView showPageListClients(){
        logger.info("Show list clients");
        ModelAndView modelAndView = new ModelAndView("client/listClients");
        List<Client> clientList = clientService.listClients();
        modelAndView.addObject("listClients",clientList);
        return modelAndView;
    }

    @RequestMapping("/new_client")
    public String showPageNewClient(Model model){
        logger.info("Show page 'new client'");
        model.addAttribute("client",new Client());
        return "client/new_client";
    }

    @RequestMapping(value = "/saveClient",method = RequestMethod.POST)
    public String addNewClient(@ModelAttribute("client") Client client){
        try {
            logger.info("Trying to add client to DB");
            clientService.addClient(client);
            logger.info("Client was added to DB");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listClients";
    }

    @RequestMapping("/edit_client/{id}")
    public ModelAndView showPageEditClient(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("client/edit_client");
        try {
            logger.info("Get information about client with id = "+id);
            Client client = clientService.getClientById(id);
            modelAndView.addObject("client",client);
            logger.info("Client was got");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit_client/client",method = RequestMethod.POST)
    public String editClient(@ModelAttribute("client") Client client){
        try {
            logger.info("Trying to edit client with id = "+client.getId());
            clientService.updateClient(client);
            logger.info("Client was edited");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listClients";
    }

    @RequestMapping("/delete_client/{id}")
    public String deleteClient(@PathVariable int id){
        try {
            logger.info("Trying to delete client with id = "+id);
            clientService.removeClient(id);
            logger.info("Client was deleted");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listClients";
    }


    @RequestMapping("/search_client/{id}")
    public ModelAndView detailsWorker(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("client/details_client");
        try {
            logger.info("Trying to get information about client with id = "+id);
            Client client = clientService.getClientById(id);
            modelAndView.addObject("client",client);
            logger.info("Client was got");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return modelAndView;
    }

}