package com.thuchanh.cart.controller;

import com.thuchanh.cart.entity.Cart;
import com.thuchanh.cart.entity.Product;
import com.thuchanh.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart(new HashSet<>());
    }

    @GetMapping({"/index", "", "/"})
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("list", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product/view/{id}")
    public String show(@PathVariable("id") Long id  ,Model model) {
        model.addAttribute("object",productService.findById(id).get());
        return "/product/view";
    }
@PostMapping("/save")
    public String save(@RequestParam("id") Long id,@RequestParam("amount") int amount, @ModelAttribute("cart") Cart cart,Model model) {
                  Product product= productService.findById(id).get();
            product.setAmount(amount);
            productService.save(product);
            cart.getProducts().remove(product);
            cart.getProducts().add(product);
        model.addAttribute("mess", "add in cart");
        return "redirect:/cart/cart";
}


}