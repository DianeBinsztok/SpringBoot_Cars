package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonitoringController {

    @GetMapping(value = "/ping")
    public String ping(){
        return("OK");
    }
}
