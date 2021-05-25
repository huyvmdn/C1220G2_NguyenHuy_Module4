package com.trungdoan.demosecurity.controller;


import com.trungdoan.demosecurity.model.Role;
import com.trungdoan.demosecurity.model.User;
import com.trungdoan.demosecurity.model.entity.*;
import com.trungdoan.demosecurity.service.ContractService;
import com.trungdoan.demosecurity.service.CustomerService;
import com.trungdoan.demosecurity.service.EmployeeService;
import com.trungdoan.demosecurity.service.ServiceService;
import com.trungdoan.demosecurity.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ContractController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ServiceService serviceService;

    @ModelAttribute("employees")
    public Iterable<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("entityServices")
    public Iterable<EntityService> entityServices() {
        return serviceService.findAll();
    }



    @GetMapping("contract/create/{id}" )
    public String create(@ModelAttribute("id")Long  id ,Model model) {
        Customer customer = customerService.findById(id).get();
         if (customer == null) {
             model.addAttribute("object",new Contract());
             return "/contract/create";
         }
        model.addAttribute("object",new Contract());
         model.addAttribute("customerById",id);
        return "/contract/create";
    }

    @PostMapping("/contract/save")
    public String save(@Valid @ModelAttribute("object") Contract object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        object.setEmployee(employeeService.findByEmail(currentPrincipalName));
        contractService.save(object);
        redirect.addFlashAttribute("mess","Contract "+object.getId()+" created successfully");
        return "redirect:/customer/customer";
    }

    @GetMapping("/contract/view/{id}")
    public String show(@PathVariable("id") Long id  , Model model) {
        Customer customer = customerService.findById(id).get();
        if (customer == null) {
            return "authentication/error";
        }
        model.addAttribute("object", customer);
        return "/contract/view";
    }

    @PostMapping("/contract/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        contractService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/customer/customer" ;
    }
    @GetMapping({"/contract/contract"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/contract/contract");
        Page<Contract> list =  contractService.findAll(pageable);
        if (list==null) {
            return new ModelAndView("/authentication/error");
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("contract/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", contractService.findById(id).get());
        return "contract/update";
    }

    @PostMapping("contract/update")
    public String updateObject(@Valid  @ModelAttribute("object") Contract object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/contract/update";
        }
        contractService.save(object);
        redirect.addFlashAttribute("mess", object.getId()+"updated successfully");
        return "redirect:/contract/contract";
    }

}
