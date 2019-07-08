package com.kulpekin.controllers;

import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.WorkerService;
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
public class WorkerController {


    private WorkerService workerService;

    @Autowired
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping("/listWorkers")
    public ModelAndView showWorkerPage(){
        ModelAndView modelAndView = new ModelAndView("worker/listWorkers");
        List<Worker> workerList = workerService.listWorkers();
        modelAndView.addObject("workerList",workerList);
        return modelAndView;
    }

    @RequestMapping(value = "/newWorker")
    public String newWorkerForm(Model model){
        model.addAttribute("worker",new Worker());
        return "worker/new_worker";
    }


    @RequestMapping(value = "/saveWorker",method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("worker") Worker worker){
        workerService.addWorker(worker);
        return "redirect:/listWorkers";
    }

    @RequestMapping("/edit_worker")
    public ModelAndView showPageEditWorker(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("worker/edit_worker");
        Worker worker = workerService.getWorkerById(id);
        modelAndView.addObject("worker",worker);
        return modelAndView;
    }

    @RequestMapping(value = "edit_worker/worker",method = RequestMethod.POST)
    public String editWorker(@ModelAttribute("worker") Worker worker){
        workerService.updateWorker(worker);
        return "redirect:/listWorkers";
    }

    @RequestMapping("delete_worker")
    public String deleteWorker(@RequestParam int id){
        workerService.removeWorker(id);
        return "redirect:/listWorkers";
    }

    @RequestMapping("/search_worker")
    public ModelAndView detailsWorker(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("worker/details_worker");
        Worker worker = workerService.getWorkerById(id);
        modelAndView.addObject("worker",worker);
        return modelAndView;
    }

}
