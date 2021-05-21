package com.thuchanh.ajax.controller;

import com.thuchanh.ajax.entity.Smartphone;
import com.thuchanh.ajax.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showIndex() {
        return "/index";
    }

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping("/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", smartphoneService.findById(id).get());
        return "/edit";
    }

    @PostMapping("/update")
    public String updateObject(@ModelAttribute Smartphone smartphone, RedirectAttributes redirect) {
        if (smartphone==null){
            return "/list";
        }
        smartphoneService.save(smartphone);
        redirect.addFlashAttribute("mess", smartphone.getId()+"updated successfully");
        return "redirect:/list";
    }
}
