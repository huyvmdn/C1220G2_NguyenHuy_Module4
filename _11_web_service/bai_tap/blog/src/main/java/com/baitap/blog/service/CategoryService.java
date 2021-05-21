package com.baitap.blog.service;

import com.baitap.blog.entity.Category;
import com.baitap.blog.ripository.CategoryRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements IGeneralService<Category> {
    @Autowired
    CategoryRipository categoryRipository;


    public List<Category> findAll() {
        return categoryRipository.findAll();
    }


    public Optional<Category> findById(Long id) {
        return  categoryRipository.findById(id);
    }


    public Category save(Category category) {
       return categoryRipository.save(category);
    }


    public void remove(Long id) {
        categoryRipository.deleteById(id);
    }

}
