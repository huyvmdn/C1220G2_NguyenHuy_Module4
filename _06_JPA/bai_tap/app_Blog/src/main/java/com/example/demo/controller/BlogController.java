package com.example.demo.controller;



import com.example.demo.entity.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class BlogController {

    @Autowired
    private BlogService service;

    @GetMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("list", service.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, Model model) {
        service.save(blog);
        model.addAttribute("mess", " created successfully");

        return "/index";
    }


    @GetMapping("/delete/{id}")
    public String saveBlog(@PathVariable Integer id, Model model) {
        service.deleteById(id);
        model.addAttribute("mess", " delete successfully");
        model.addAttribute("list", service.findAll());
        return "/index";
    }

    @GetMapping("/edit/{id}")
    public String updateBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", service.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, Model model) {
        service.save(blog);
        model.addAttribute("mess", " update successfully");
        model.addAttribute("list", service.findAll());
        return "/index";
    }
}
