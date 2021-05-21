package com.baitap.jpa.controller;


import com.baitap.jpa.entity.Category;
import com.baitap.jpa.entity.Detail;
import com.baitap.jpa.entity.Product;
import com.baitap.jpa.service.CartService;
import com.baitap.jpa.service.CategoryService;
import com.baitap.jpa.service.DetailService;
import com.baitap.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DetailService detailService;
    @Autowired
    private ProductService productService;

    @ModelAttribute("categorys")
    public Iterable<Category> categorys() {
        return categoryService.findAll();
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("object", new Product());
        return "/product/create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product, RedirectAttributes redirect) {

        productService.save(product);
        redirect.addFlashAttribute("mess", "Blog" + product.getId() + "created successfully");
        return "redirect:/product/product";
    }

    @PostMapping("/product/delete")
    public String delete(@RequestParam("idDelete") Long idDelete, Model model) {
        productService.deleteById(idDelete);
        model.addAttribute("mess", " delete successfully");
        return "redirect:/product/product";
    }


    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("object", productService.findById(id));
        return "/product/edit";
    }

    @PostMapping("/product/update")
    public String update(@ModelAttribute Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("mess", +product.getId() + "updated successfully");
        return "redirect:/product/product";
    }

    @GetMapping("/product/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Product product= productService.findById(id).get();
        model.addAttribute("img", product.getDetail().getImage());
        model.addAttribute("object", product);
        return "/product/view";
    }

    @GetMapping("/product/show/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        model.addAttribute("list", productService.findById(id).get().getCarts());
        return "/cart/cart";
    }

}
