package com.blog.newblog.controller;


import com.blog.newblog.entity.Blog;
import com.blog.newblog.entity.Category;
import com.blog.newblog.service.BlogService;
import com.blog.newblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/category")
    public String GetCategory(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        return "/category/category";
    }

    @GetMapping("/createCategory")
    public String getCreate(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/saveCategory")
    public String saveBlog(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("categorys", categoryService.findAll());
        return "/category/category";
    }

    @PostMapping("/deleteCategory")
    public String deleteBlog(@RequestParam("idDelete") Long idDelete, Model model) {
        categoryService.remove(idDelete);
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("mess", " delete successfully");
        return "/category/category";
    }

    @GetMapping("/editCategory/{id}")
    public String updateBlog(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping("/updateCategory")
    public String updateBlog(@ModelAttribute Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("mess", " update successfully");
        model.addAttribute("categorys", categoryService.findAll());
        return "/category/category";
    }

        @GetMapping("/showCategory/{id}")
        public String showBlog(@PathVariable Long id, Model model) {
           Category category= categoryService.findById(id);
           model.addAttribute("blogs",category.getBlogs());
        return "/category/show";
    }

}
