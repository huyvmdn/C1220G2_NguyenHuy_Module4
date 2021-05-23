package com.trungdoan.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping
    public String getHomePage(){
        return "/home";
    }

    @GetMapping("/lang")
    public String getLang(){
        return "/home";
    }
}
