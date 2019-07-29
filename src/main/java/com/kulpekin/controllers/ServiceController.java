package com.kulpekin.controllers;


import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.PoslugaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ServiceController {

    private static final Logger logger = Logger.getLogger(ServiceController.class);
    private PoslugaService poslugaService;

    @Autowired
    @Qualifier(value = "poslugaService")
    public void setPoslugaService(PoslugaService poslugaService) {
        this.poslugaService = poslugaService;
    }

    @RequestMapping("/index")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("service/index");
        try{
            logger.info("Showing list services...");
            List<Service> serviceList = poslugaService.listServices();
            modelAndView.addObject("listService",serviceList);
            logger.info(serviceList.toString());
        }catch (Exception exception){
            logger.error("Exception:"+exception.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping("/new")
    public String newServiceForm(Model model){
        model.addAttribute("service",new Service());
        return "service/new_service";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveService(@ModelAttribute("service") Service service){
        try {
            logger.info("Trying to add service to DB...");
            poslugaService.addService(service);
            logger.info("Service is added to DB");
        }catch (Exception exception){
            logger.error("Exception:"+exception.getMessage());
        }
        return "redirect:/index";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editServiceForm(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("service/edit_service");
        Service service = poslugaService.getServiceById(id);
        modelAndView.addObject("service",service);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/service",method = RequestMethod.POST)
    public String editService(@ModelAttribute("service") Service service){
        try {
            logger.info("Trying to edit service");
            poslugaService.updateService(service);
            logger.info("Service is edited");
        }catch (Exception exception){
            logger.error("Exception:"+exception.getMessage());
        }
        return "redirect:/index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteService(@PathVariable int id){
        try {
            logger.info("Trying to delete service by id = "+id);
            poslugaService.removeService(id);
            logger.info("Service is deleted");
        }catch (Exception exception){
            logger.error("Exception:"+exception.getMessage());
        }
        return "redirect:/index";
    }

    @RequestMapping("/search/{id}")
    public ModelAndView detailsService(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("service/details_service");
        try {
            logger.info("Trying to get information about id = "+ id);
            Service service = poslugaService.getServiceById(id);
            modelAndView.addObject("service",service);
            logger.info("Got information about id = " + id);
        }catch (Exception exception){
            logger.error("Exception:"+exception.getMessage());
        }
        return modelAndView;
    }

}
