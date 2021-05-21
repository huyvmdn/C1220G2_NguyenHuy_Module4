package com.example.img_in_day.controller;

import com.example.img_in_day.entity.Comment;
import com.example.img_in_day.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

     @Autowired
     CommentService service;

    @GetMapping({"","/","/index"})
    public String getIndex(Model model) {
        model.addAttribute("list",service.findAll());
        model.addAttribute("comment",new Comment());
//        model.addAttribute("countStar",service.countbyStar());
        return "/index";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Comment comment) {
        service.save(comment);
        return "redirect:/index";
    }


}
