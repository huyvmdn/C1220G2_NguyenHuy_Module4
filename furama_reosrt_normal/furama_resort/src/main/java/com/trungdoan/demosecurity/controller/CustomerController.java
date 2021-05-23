package com.trungdoan.demosecurity.controller;

import com.trungdoan.demosecurity.model.entity.Customer;
import com.trungdoan.demosecurity.model.entity.CustomerType;
import com.trungdoan.demosecurity.service.CustomerService;
import com.trungdoan.demosecurity.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> categorys() {
        return customerTypeService.findAll();
    }



    @GetMapping("/customer/customer")
    public ModelAndView getIndex(@PageableDefault(value = 8) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/customer");
        Page<Customer> list =  customerService.findAll(pageable);
        if (list==null) {
            return new ModelAndView("/authentication/403");
        }
        modelAndView.addObject("list",list);
        modelAndView.addObject("object",new Customer());
        return modelAndView;
    }

    @GetMapping("customer/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", customerService.findById(id).get());
        return "customer/update";
    }

    @PostMapping("customer/update")
    public String updateObject(@Valid  @ModelAttribute("object") Customer object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer/update";
        }
        customerService.save(object);
        redirect.addFlashAttribute("mess", object.getId()+"updated successfully");
        return "redirect:/customer/customer";
    }

    @GetMapping("/customer/create")
    public String create(Model model) {
        model.addAttribute("object", new Customer());
        return "/customer/create";
    }


    @PostMapping("/customer/save")
    public String save(@Valid  @ModelAttribute("object") Customer object, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasFieldErrors()) {
            return "/customer/create";
        }
        customerService.save(object);
        redirect.addFlashAttribute("mess","User "+object.getId()+" "+object.getName()+" created successfully");
        return "redirect:/customer/customer";
    }

    @PostMapping("/customer/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        customerService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/customer/customer";
    }

    @GetMapping("/customer/search")
    public String search(@RequestParam(value = "customerName", defaultValue = "") String customerName,
                         @RequestParam(value = "address", defaultValue = "") String address,
                         @RequestParam(value = "customerType", defaultValue = "") String customerType,

                         @PageableDefault(value = 8) Pageable pageable,
                         Model model) {

            model.addAttribute("list", customerService.search3(customerName, address, customerType,pageable));
            model.addAttribute("customerName", customerName);
            model.addAttribute("address", address);
            model.addAttribute("customerType", customerType);
        return "/customer/customer";
    }
}
