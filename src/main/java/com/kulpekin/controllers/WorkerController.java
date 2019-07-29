package com.kulpekin.controllers;

import com.kulpekin.models.Worker;
import com.kulpekin.service.interfaceService.WorkerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WorkerController {

    private WorkerService workerService;

    private final Logger logger = Logger.getLogger(WorkerController.class);

    @Autowired
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping("/listWorkers")
    public ModelAndView showWorkerPage(){
        logger.info("Show list worker page");
        ModelAndView modelAndView = new ModelAndView("worker/listWorkers");
        List<Worker> workerList = workerService.listWorkers();
        modelAndView.addObject("workerList",workerList);
        return modelAndView;
    }

    @RequestMapping(value = "/newWorker")
    public String newWorkerForm(Model model){
        logger.info("Show add worker page");
        model.addAttribute("worker",new Worker());
        return "worker/new_worker";
    }


    @RequestMapping(value = "/saveWorker",method = RequestMethod.POST)
    public String saveWorker(@ModelAttribute("worker") Worker worker){
        try {
            logger.info("Trying to add worker to DB");
            workerService.addWorker(worker);
            logger.info("Worker was added to DB");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listWorkers";
    }

    @RequestMapping("/edit_worker/{id}")
    public ModelAndView showPageEditWorker(@PathVariable int id){
        logger.info("Show page edit worker");
        ModelAndView modelAndView = new ModelAndView("worker/edit_worker");
        Worker worker = workerService.getWorkerById(id);
        modelAndView.addObject("worker",worker);
        return modelAndView;
    }

    @RequestMapping(value = "/edit_worker/worker",method = RequestMethod.POST)
    public String editWorker(@ModelAttribute("worker") Worker worker){
        try {
            logger.info("Trying to edit worker with id = "+worker.getId());
            workerService.updateWorker(worker);
            logger.info("Worker was edited");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listWorkers";
    }

    @RequestMapping("/delete_worker/{id}")
    public String deleteWorker(@PathVariable int id){
        try {
            logger.info("Trying to delete worker with id =" + id);
            workerService.removeWorker(id);
            logger.info("Worker was deleted");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return "redirect:/listWorkers";
    }

    @RequestMapping("/search_worker/{id}")
    public ModelAndView detailsWorker(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("worker/details_worker");
        try {
            logger.info("Tring to get information about worker with id = "+id);
            Worker worker = workerService.getWorkerById(id);
            modelAndView.addObject("worker",worker);
            logger.info("Information was got");
        }catch (Exception exception){
            logger.error("Exception:"+exception.toString());
        }
        return modelAndView;
    }

}
