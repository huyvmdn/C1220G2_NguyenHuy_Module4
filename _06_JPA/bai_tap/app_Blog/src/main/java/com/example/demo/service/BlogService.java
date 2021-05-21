package com.example.demo.service;

import com.example.demo.entity.Blog;
import com.example.demo.ripository.Ripository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private Ripository ripository;

    public List<Blog> findAll() {
        return ripository.findAll();
    }

    public Blog findById(Integer id) {
        return ripository.findById(id).orElse(null);
    }

    public void save(Blog blog) {
        ripository.save(blog);

    }

    public void delete(Blog blog) {
        ripository.delete(blog);
    }

    public void deleteById(Integer id) {
        ripository.deleteById(id);
    }
}