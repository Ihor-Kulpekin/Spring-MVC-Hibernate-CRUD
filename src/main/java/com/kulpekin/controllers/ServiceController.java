package com.kulpekin.controllers;


import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.PoslugaService;
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
public class ServiceController {

    private PoslugaService poslugaService;

    @Autowired
    @Qualifier(value = "poslugaService")
    public void setPoslugaService(PoslugaService poslugaService) {
        this.poslugaService = poslugaService;
    }

    @RequestMapping("/index")
    public ModelAndView home(){
        List<Service> serviceList = poslugaService.listServices();
        ModelAndView modelAndView = new ModelAndView("service/index");
        modelAndView.addObject("listService",serviceList);
        return modelAndView;
    }

    @RequestMapping("/new")
    public String newServiceForm(Model model){
        model.addAttribute("service",new Service());
        return "service/new_service";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveService(@ModelAttribute("service") Service service){
        poslugaService.addService(service);
        return "redirect:/index";
    }

    @RequestMapping("/edit")
    public ModelAndView editServiceForm(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("service/edit_service");
        Service service = poslugaService.getServiceById(id);
        modelAndView.addObject("service",service);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/service",method = RequestMethod.POST)
    public String editService(@ModelAttribute("service") Service service){
        poslugaService.updateService(service);
        return "redirect:/index";
    }

    @RequestMapping("delete")
    public String deleteService(@RequestParam int id){
        poslugaService.removeService(id);
        return "redirect:/index";
    }

    @RequestMapping("/search")
    public ModelAndView detailsService(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("service/details_service");
        Service service = poslugaService.getServiceById(id);
        modelAndView.addObject("service",service);
        return modelAndView;
    }

}
