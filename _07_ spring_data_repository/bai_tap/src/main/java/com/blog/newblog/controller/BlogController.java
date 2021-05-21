package com.blog.newblog.controller;


import com.blog.newblog.entity.Blog;
import com.blog.newblog.entity.Category;
import com.blog.newblog.service.BlogService;
import com.blog.newblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categorys() {
        return categoryService.findAll();
    }


    @GetMapping({"","/","/index","/blogs"})
    public String Getindex( Model model,@PageableDefault(value = 5)Pageable pageable, Model mode ) {
        model.addAttribute("blogs",blogService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("mess", "Blog" +blog.getId()+"created successfully");
        return "redirect:/index";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam( "idDelete") Long idDelete,@PageableDefault(value = 5)Pageable pageable, Model model) {
        blogService.remove(idDelete);
        model.addAttribute("mess", " delete successfully");
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "/index";
    }

    @GetMapping("/edit/{id}")
    public String updateBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, Model model) {
        blogService.save(blog);

        Pageable pageable = PageRequest.of(0,5,Sort.by("name").ascending());
        model.addAttribute("mess", " update successfully");
        model.addAttribute("blogs", blogService.findAll(pageable));
        return "/index";
    }
    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String viewBlog(@RequestParam("search") String search, Model model,@PageableDefault(value = 5)Pageable pageable) {
        model.addAttribute("blogs", blogService.findAllByTitleContaining(search,pageable));
        return "/index";
    }

    @GetMapping("/sort")
    public String sort( Model model, @PageableDefault(value = 5) Pageable pageable) {
        List<Blog> sorts= blogService.sort();
        Page<Blog> pages = new PageImpl<>(sorts, pageable, sorts.size());
        model.addAttribute("blogs", pages);
        return "index";
    }

}
