package com.baitap.ajax.controller;

import com.baitap.ajax.entity.Blog;
import com.baitap.ajax.entity.Category;
import com.baitap.ajax.service.IBlogService;
import com.baitap.ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Controller
public class BlogController {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;


    @ModelAttribute("categories")
    public List<Category>  setup() {
        List<Category> categories= (List<Category>) categoryService.findAll();
        return categories ;
    }
    @GetMapping("/lang")
    public String changeLanguage(){
        return "redirect:/index";
    }

    @GetMapping({"/index", "", "/","/blog"})
    public ModelAndView getIndex(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index");
        Page<Blog> list =  blogService.findAll(pageable);
        if (list==null) {
            return new ModelAndView("/error.404");
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @GetMapping("/blog/view/{id}")
    public String show(@PathVariable("id") Long id  ,Model model) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            return "/error.404";
        }
        model.addAttribute("object", blog);
        return "/blog/view";
    }

    @GetMapping("/blog/create")
    public String createObject(Model model) {
        model.addAttribute("object", new Blog());
        return "/blog/create";
    }

@PostMapping("/blog/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirect) {
    if (blog == null) {
        return "/error.404";
    }
    blog.setDateBlog(LocalDate.now());
    blogService.save(blog);
    redirect.addFlashAttribute("mess", blog.getTitle()+"created successfully");
        return "redirect:/index";
}

    @GetMapping("/blog/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id).get();
        if (blog == null) {
            return "/error.404";
        }
        model.addAttribute("object", blog);
        return "blog/edit";
    }

    @PostMapping("/blog/update")
    public String updateObject(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        if (blog==null){
            return "/error.404";
        }
        blogService.save(blog);
        redirect.addFlashAttribute("mess", blog.getTitle()+"updated successfully");
        return "redirect:/index";
    }

    @GetMapping("/search/{name}")
    public ModelAndView search(@PathVariable("name") String name,@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/blog/search");
         Page<Blog> blogs = blogService.findByTitleContaining(name,pageable);
        if (blogs==null) {
            return new ModelAndView("/error.404");
        }
        modelAndView.addObject("list",blogs);
        return modelAndView;
    }

    @GetMapping("/load/{more}")
    public String getHomePageable(@PathVariable Integer more,Model model){
        Pageable pageable1= PageRequest.of(more,5);
        List<Blog> customers=blogService.findAll(pageable1).getContent();
        model.addAttribute("list",customers );
        return "/blog/search";
    }

}