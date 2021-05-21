package com.baitap.ajax.service.imp;

import com.baitap.ajax.entity.Category;

import com.baitap.ajax.ripository.CategoryRipository;
import com.baitap.ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRipository categoryRipository;


    public List<Category> findAll() {
        return categoryRipository.findAll();
    }


    public Optional<Category> findById(Long id) {
        return  categoryRipository.findById(id);
    }


    public Page<Category> findAll(Pageable pageable) {
        return categoryRipository.findAll(pageable);
    }

    public Category save(Category category) {
       return categoryRipository.save(category);
    }
    
    @Override
    public void deleteById(Long id) {
        categoryRipository.deleteById(id);
    }


}
