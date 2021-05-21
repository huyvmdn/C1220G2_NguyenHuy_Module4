package com.baitap.jpa.service;

import com.baitap.jpa.entity.Category;
import com.baitap.jpa.repository.CategoryRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService implements GeneralService<Category> {

    @Autowired
    private CategoryRipository categoryRipository;


    @Override
    public List<Category> findAll() {
        return categoryRipository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRipository.findById(id);
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRipository.findAll(pageable);
    }



    @Override
    public void save(Category category) {
        categoryRipository.save(category);
    }

    @Override
    public void deleteById(Long id) {
    categoryRipository.deleteById(id);
    }
}
