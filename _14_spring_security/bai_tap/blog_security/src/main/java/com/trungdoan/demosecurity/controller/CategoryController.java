package com.trungdoan.demosecurity.controller;

import com.trungdoan.demosecurity.entity.Blog;
import com.trungdoan.demosecurity.entity.Category;
import com.trungdoan.demosecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {



    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category/category")
    public String getCategory(Model model, @PageableDefault(value = 8) Pageable pageable) {
        Page<Category> list= categoryService.findAll(pageable);
        if (list==null) {
            return "/blog/blog";
        }
        model.addAttribute("list",list );
        return "/category/category";
    }

    @GetMapping("/category/create")
    public String createObject(Model model) {
        model.addAttribute("object", new Category());
        return "/category/create";
    }

    @PostMapping("/category/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirect) {
        if (category == null) {
            return "/error.404";
        }
        categoryService.save(category);
        redirect.addFlashAttribute("mess", category.getName()+"created successfully");
        return "redirect:/index";
    }

    @GetMapping("/category/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", categoryService.findById(id).orElse(null));
        return "/category/edit";
    }

    @PostMapping("/category/update")
    public String updateObject(@ModelAttribute Category category, RedirectAttributes redirect) {
        if (category==null){
            return "/error.404";
        }
        categoryService.save(category);
        redirect.addFlashAttribute("mess", category.getId()+"updated successfully");
        return "redirect:/category/category";
    }
    @PostMapping("/category/delete")
    public String deleteObject(@RequestParam( "idDelete") Long idDelete, Model model) {
        categoryService.deleteById(idDelete);
        model.addAttribute("mess", " deleted successfully");
        return "redirect:/category/category";
    }

    @GetMapping("/category/show/{id}")
    public String showObject(@PathVariable Long id, Model model, @PageableDefault(value = 8) Pageable pageable) {
        Category category= categoryService.findById(id).orElse(null);
        if (category==null){
            return "/blog/blog";
        }
        List<Blog> list = category.getBlogs();
        Page<Blog> pages = new PageImpl<Blog>(list, pageable, list.size());
        model.addAttribute("list", pages);
        return "/blog/blog";
    }
}