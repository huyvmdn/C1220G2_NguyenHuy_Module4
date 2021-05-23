package com.trungdoan.demosecurity.controller;


import com.trungdoan.demosecurity.model.entity.Customer;
import com.trungdoan.demosecurity.model.entity.Employee;
import com.trungdoan.demosecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/employee/employee"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/employee/employee");
        Page<Employee> list = employeeService.findAll(pageable);
        if (list == null) {
            return new ModelAndView("/authentication/403");
        }
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}

