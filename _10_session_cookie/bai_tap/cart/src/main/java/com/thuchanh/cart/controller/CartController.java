package com.thuchanh.cart.controller;

import com.thuchanh.cart.entity.Cart;
import com.thuchanh.cart.entity.Product;
import com.thuchanh.cart.service.CartService;
import com.thuchanh.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;

@Controller
public class CartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart(new HashSet<>());
    }

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/cart/cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        if (cart==null) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/cart/set/{id}")
    public ModelAndView set (@SessionAttribute("cart") Cart cart, @RequestParam("amount") int amount, @PathVariable("id") Long id){
        Product product= productService.findById(id).get();
        if (product==null){
            return new ModelAndView("/error.404");
        }
        product.setAmount(amount);
        productService.save(product);
        cart.getProducts().add(product);
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/cart/add")
    public String add (@SessionAttribute("cart") Cart cart){
        if (cart ==null){
            return  "/error.404";
        }
        cartService.save(cart);
        return "redirect:/index";
    }
    @GetMapping("/cart/search")
    public String search (@RequestParam("id")Long id, Model model){
       model.addAttribute("cart",cartService.findById(id).get());
        return "cart/cart";
    }
}