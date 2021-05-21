package com.blog.newblog.service;

import com.blog.newblog.entity.Blog;
import com.blog.newblog.ripository.BlogRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class BlogService  {

    @Autowired
    BlogRipository blogRipository;


   public Page<Blog> findAll(Pageable pageable){
        return blogRipository.findAll(pageable);
    }

    public List<Blog> sort() {
       return blogRipository.sort();
    }

    public List<Blog> findAll(){
        return blogRipository.findAll();
    }

    public Page<Blog> findAllByTitleContaining(String search, Pageable pageable) {
        return blogRipository.findAllByTitleContaining(search,pageable);
    }
    List<Blog> findAllByCategoryId(Integer id) {
        return blogRipository.findAllByCategoryId(id);
    };


    public Blog findById(long id) {
        return  blogRipository.findById(id).orElse(null);
    }


    public void save(Blog blog) {
        blogRipository.save(blog);
    }


    public void remove(Long id) {
        blogRipository.deleteById(id);
    }

}
