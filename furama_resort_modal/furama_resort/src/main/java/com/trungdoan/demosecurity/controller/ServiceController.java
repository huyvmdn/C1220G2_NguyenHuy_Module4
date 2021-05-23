package com.trungdoan.demosecurity.controller;


import com.trungdoan.demosecurity.model.entity.Customer;
import com.trungdoan.demosecurity.model.entity.EntityService;
import com.trungdoan.demosecurity.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping({"/service/service"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/service/service");
        Page<EntityService> list =  serviceService.findAll(pageable);
        if (list==null) {
            return new ModelAndView("/authentication/403");
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }

}
