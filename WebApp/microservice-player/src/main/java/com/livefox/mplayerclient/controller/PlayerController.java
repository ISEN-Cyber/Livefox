package com.livefox.mplayerclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path ={"/stream/{name}"})
    public String stream(@PathVariable String name,Model model){
        model.addAttribute("name", name);
        log.info("Request stream page");
        return "stream";
    }   
}