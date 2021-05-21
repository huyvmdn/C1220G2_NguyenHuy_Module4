package com.baitap.jpa.controller;


import com.baitap.jpa.entity.Cart;
import com.baitap.jpa.entity.Category;
import com.baitap.jpa.entity.Product;
import com.baitap.jpa.service.CartService;
import com.baitap.jpa.service.CategoryService;
import com.baitap.jpa.service.DetailService;
import com.baitap.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ProductService productService;

    @GetMapping({"", "/", "/index"})
    public String getIndex() {
        return "/index";
    }

    @GetMapping("/cart/cart")
    public String getCart(Model model, @PageableDefault(value = 8) Pageable pageable) {
        Page<Cart> list= cartService.findAll(pageable);
        if (list==null) {
            return "/index";
        }
        model.addAttribute("list", list);
        return "/cart/cart";
    }

    @GetMapping("/product/product")
    public String getProduct(Model model, @PageableDefault(value = 8) Pageable pageable) {
        Page<Product> list= productService.findAll(pageable);
        if (list==null) {
            return "/index";
        }
        model.addAttribute("list", list);
        return "/product/product";
    }

    @GetMapping("/category/category")
    public String getCategory(Model model, @PageableDefault(value = 8) Pageable pageable) {
        Page<Category> list= categoryService.findAll(pageable);
        if (list==null) {
            return "/index";
        }
        model.addAttribute("list",list );
        return "/category/category";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "price", defaultValue = "") String price,
                         @RequestParam(value = "date1", defaultValue = "") String date1,
                         @RequestParam(value = "date2", defaultValue = "") String date2,
                         @PageableDefault(value = 8) Pageable pageable,
                         Model model) {
        if (date1.equals("") || date2.equals("")) {
            model.addAttribute("list", cartService.seach(name, price, pageable));
            model.addAttribute("name", name);
            model.addAttribute("price", price);
        } else {
            model.addAttribute("list", cartService.searchFull(name, price, date1, date2,pageable));
            model.addAttribute("name", name);
            model.addAttribute("price", price);
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
        }
        return "/cart/cart";
    }
    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam(value = "name", defaultValue = "") String name,
                         @RequestParam(value = "price", defaultValue = "") String price,
                         @RequestParam(value = "date1", defaultValue = "") String date1,
                         @RequestParam(value = "date2", defaultValue = "") String date2,
                         @PageableDefault(value = 8) Pageable pageable,
                         Model model) {
        if (date1.equals("") || date2.equals("")) {
            model.addAttribute("list", productService.seach(name, price, pageable));
            model.addAttribute("name", name);
            model.addAttribute("price", price);
        } else {
            model.addAttribute("list", productService.searchFull(name, price, date1, date2,pageable));
            model.addAttribute("name", name);
            model.addAttribute("price", price);
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
        }
        return "/product/product";
    }
}
