package com.testfinal.module4.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class HomeController {

    @GetMapping({"","/","/home"})
    public String getHomePage(){
        return "/home";
    }

    @GetMapping("/lang")
    public String getLang(){
        return "/home";
    }
}
