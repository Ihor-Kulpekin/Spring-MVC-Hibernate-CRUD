package com.kulpekin.controllers;

import com.kulpekin.models.Client;
import com.kulpekin.models.NameService;
import com.kulpekin.models.Ordering;
import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.OrderingService;
import org.apache.log4j.Logger;
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
public class OrderingController {

    private OrderingService orderingService;

    private final Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    @Qualifier("orderingService")
    public void setOrderingService(OrderingService orderingService) {
        this.orderingService = orderingService;
    }

    @RequestMapping("listOrdering")
    public ModelAndView showPAgeListOrdering(){
        logger.info("Show list of ordering");
        ModelAndView modelAndView = new ModelAndView("ordering/listOrdering");
        List<Ordering> orderingList = orderingService.listOrderings();
        modelAndView.addObject("listOrdering",orderingList);
        return modelAndView;
    }

    @RequestMapping("/new_Ordering")
    public String showPageAddOrdering(Model model){
        List<Client> clientList = orderingService.listClients();
        List<Worker> workerList = orderingService.listWorkers();
        List<NameService> nameServiceList = orderingService.listNameService();
        model.addAttribute("ordering",new Ordering());
        model.addAttribute("listClients",clientList);
        model.addAttribute("listWorkers",workerList);
        model.addAttribute("listNameService",nameServiceList);
        return "ordering/new_ordering";
    }

    @RequestMapping(value = "/save_ordering",method = RequestMethod.POST)
    public String addOrdering(@ModelAttribute("ordering") Ordering ordering){
        try {
            logger.info("Trying to ad ordering to DB");
            orderingService.addOrdering(ordering);
            logger.info("Ordering was added");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listOrdering";
    }

    @RequestMapping("/edit_ordering")
    public ModelAndView showPageEditOrdering(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("ordering/edit_ordering");
        try {
            logger.info("Trying to get ordering with id = "+id);
            Ordering ordering = orderingService.getOrderingById(id);
            modelAndView.addObject("ordering",ordering);
            logger.info("Ordering was got");
        }catch (Exception exception){
            logger.error("Exception:"+ exception.toString());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit_ordering/ordering",method = RequestMethod.POST)
    public String editOrdering(@ModelAttribute("ordering") Ordering ordering){
       try {
           logger.info("Trying to edit ordering with id = "+ ordering.getId());
           orderingService.updateOrdering(ordering);
           logger.info("Ordering was edited");
       }catch (Exception exception){
           logger.error("Exception:"+exception.toString());
       }
        return "redirect:/listOrdering";
    }

    @RequestMapping("/delete_ordering")
    public String deleteOrdering(@RequestParam int id){
        try {
            logger.info("Trying to delete ordering with id = "+id);
            orderingService.removeOrdering(id);
            logger.info("Ordering was deleted");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listOrdering";
    }

    @RequestMapping("/search_ordering")
    public ModelAndView detailsOrdering(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("ordering/details_ordering");
        try {
            logger.info("Trying to get information about ordering with id = "+id);
            Ordering ordering = orderingService.getOrderingById(id);
            modelAndView.addObject("ordering",ordering);
            logger.info("Ordering was got");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return modelAndView;
    }

}
