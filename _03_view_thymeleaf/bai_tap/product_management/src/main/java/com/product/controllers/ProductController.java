package com.product.controllers;


import com.product.model.Product;
import com.product.service.IProductService;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    IProductService productService = new ProductService();

    @GetMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("product",new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Product product, Model model) {
        productService.create(product);
        model.addAttribute("products", productService.findAll());
        return "/index";
    }

    @GetMapping("/{id}/edit")
    public String updatePage(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findId(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.create( product);
        return "redirect:/index";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findId(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/index";
    }
}