package com.kulpekin.controllers;

import com.kulpekin.models.NameService;
import com.kulpekin.models.Service;
import com.kulpekin.service.interfaceService.NamePoslugaService;
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
public class NameServiceController {

    private NamePoslugaService namePoslugaService;

    @Autowired
    @Qualifier("namePoslugaService")
    public void setNamePoslugaService(NamePoslugaService namePoslugaService) {
        this.namePoslugaService = namePoslugaService;
    }

    @RequestMapping("/listNameService")
    public ModelAndView showPageListNameService(){
        ModelAndView modelAndView = new ModelAndView("nameService/listNameService");
        List<NameService> nameServiceList = namePoslugaService.listNameServices();
        modelAndView.addObject("listNameService",nameServiceList);
        return modelAndView;
    }

    @RequestMapping("/new_nameService")
    public String showPageNewNameService(Model model){
        List<Service> serviceList = namePoslugaService.listServices();
        model.addAttribute("nameService",new NameService());
        model.addAttribute("listServices",serviceList);
        return "nameService/new_nameservice";
    }

    @RequestMapping(value = "/saveNameService",method = RequestMethod.POST)
    public String addNameService(@ModelAttribute("nameService") NameService nameService){
        namePoslugaService.insertNameService(nameService);
        return "redirect:/listNameService";
    }

    @RequestMapping("/edit_nameservice")
    public ModelAndView showPageEditNameService(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("nameService/edit_nameservice");
        NameService nameService = namePoslugaService.getNameServiceById(id);
        modelAndView.addObject("nameService",nameService);
        return modelAndView;
    }

    @RequestMapping(value = "edit_nameservice/nameservice",method = RequestMethod.POST)
    public String editNameService(@ModelAttribute("nameService") NameService nameService){
        namePoslugaService.updateNameService(nameService);
        return "redirect:/listNameService";
    }

    @RequestMapping("/delete_nameservice")
    public String deleteNameService(@RequestParam int id){
        namePoslugaService.deleteNameService(id);
        return "redirect:/listNameService";
    }


    @RequestMapping("/search_nameservice")
    public ModelAndView detailsNameService(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("nameService/details_nameservice");
        NameService nameService = namePoslugaService.getNameServiceById(id);
        modelAndView.addObject("nameService",nameService);
        return modelAndView;
    }

}
