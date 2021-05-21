package com.trungdoan.demosecurity.controller;


import com.trungdoan.demosecurity.entity.Blog;
import com.trungdoan.demosecurity.entity.Category;
import com.trungdoan.demosecurity.service.IBlogService;
import com.trungdoan.demosecurity.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiBlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/{CategoryId}")
    public ResponseEntity<Iterable<Blog>> findBlogByCategory(@PathVariable Long categoryId) {
                Category category= categoryService.findById(categoryId).get();
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogs(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Blog> save(@RequestBody Blog blog) {

        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }
    @PostMapping("/save2")
    public ResponseEntity<Category> save2(@RequestBody Category c) {
        return new ResponseEntity<>(categoryService.save(c), HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<Iterable<Blog>> save2(@RequestBody String title) {
//        List<Blog> blogs = (List<Blog>) blogService.findByTitleContaining(title);
        List<Blog> blogs= (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }

}
