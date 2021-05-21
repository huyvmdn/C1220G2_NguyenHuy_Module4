package com.baitap.jpa.controller;


import com.baitap.jpa.entity.Cart;
import com.baitap.jpa.service.CartService;
import com.baitap.jpa.service.CategoryService;
import com.baitap.jpa.service.DetailService;
import com.baitap.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ProductService productService;

    @GetMapping("/cart/show/{id}")
    public String view(@PathVariable Long id, Model model) {
        Cart cart= cartService.findById(id).get();
        if (cart==null){
            return "/index";
        }
        model.addAttribute("object", cart);
        model.addAttribute("list", cart.getProducts());
        return "/cart/show";
    }
}
