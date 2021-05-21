package com.blog.newblog.service;


import com.blog.newblog.entity.Blog;
import com.blog.newblog.entity.Category;
import com.blog.newblog.ripository.BlogRipository;
import com.blog.newblog.ripository.CategoryRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRipository categoryRipository;


    public List<Category> findAll() {
        return categoryRipository.findAll();
    }


    public Category  findById(Long id) {
        return  categoryRipository.findById(id).orElse(null);
    }


    public void save(Category category) {
        categoryRipository.save(category);
    }


    public void remove(Long id) {
        categoryRipository.deleteById(id);
    }

}
