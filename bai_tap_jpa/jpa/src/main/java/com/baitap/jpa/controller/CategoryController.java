package com.baitap.jpa.controller;


import com.baitap.jpa.entity.Category;

import com.baitap.jpa.entity.Product;
import com.baitap.jpa.service.CartService;
import com.baitap.jpa.service.CategoryService;
import com.baitap.jpa.service.DetailService;
import com.baitap.jpa.service.ProductService;
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
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ProductService productService;



    @GetMapping("/category/create")
    public String createObject(Model model) {
        model.addAttribute("object", new Category());
        return "/category/create";
    }

    @PostMapping("/category/save")
    public String saveObject(@ModelAttribute Category category, RedirectAttributes redirect) {
        if (category==null){
            return "/index";
        }
        categoryService.save(category);
        redirect.addFlashAttribute("mess", "Blog" +category.getId()+"created successfully");
        return "redirect:/category/category";
    }
    @PostMapping("/category/delete")
    public String deleteObject(@RequestParam( "idDelete") Long idDelete, Model model) {
         categoryService.deleteById(idDelete);
        model.addAttribute("mess", " deleted successfully");
        return "redirect:/category/category";
    }

    @GetMapping("/category/edit/{id}")
    public String editObject(@PathVariable Long id, Model model) {
        model.addAttribute("object", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("/category/update")
    public String updateObject(@ModelAttribute Category category, RedirectAttributes redirect) {
        if (category==null){
            return "/index";
        }
        categoryService.save(category);
        redirect.addFlashAttribute("mess", category.getId()+"updated successfully");
        return "redirect:/category/category";
    }

    @GetMapping("/category/show/{id}")
    public String showObject(@PathVariable Long id, Model model, @PageableDefault(value = 8) Pageable pageable) {
        Category category= categoryService.findById(id).orElse(null);
        if (category==null){
            return "/index";
        }
        List<Product> products = category.getProducts();
        Page<Product> pages = new PageImpl<Product>(products, pageable, products.size());
            model.addAttribute("list", pages);
        return "/product/product";
    }
}
