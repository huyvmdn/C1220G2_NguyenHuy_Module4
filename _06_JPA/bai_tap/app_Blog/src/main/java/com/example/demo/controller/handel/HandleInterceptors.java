package com.example.demo.controller.handel;

import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandleInterceptors implements HandlerInterceptor {
    @Autowired
    BlogService service;

    public boolean preHandle(Model model, HttpServletResponse response, Object handler) throws Exception {
        model.addAttribute("list", service.findAll());
        return true;
    }
}
