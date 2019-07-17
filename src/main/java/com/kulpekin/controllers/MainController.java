package com.kulpekin.controllers;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public String mainPage(){
        logger.info("Start logging");
        return "mainPage";
    }

}
