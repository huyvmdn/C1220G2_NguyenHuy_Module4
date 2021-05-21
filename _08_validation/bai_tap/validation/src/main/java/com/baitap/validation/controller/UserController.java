package com.baitap.validation.controller;


import com.baitap.validation.entity.User;
import com.baitap.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping({"","/","/index"})
    public String getIndex(Model model){
        model.addAttribute("mess","");
        model.addAttribute("list",userService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("object", new User());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("object") User object , BindingResult bindingResult, RedirectAttributes redirect) {

        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        userService.save(object);
        redirect.addFlashAttribute("mess","User "+object.getFirstName()+" "+object.getLastName()+" created successfully");
        return "redirect:/index";
    }
}
