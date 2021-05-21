package com.baitap.blog.service;



import com.baitap.blog.entity.Blog;
import com.baitap.blog.entity.Category;
import com.baitap.blog.ripository.BlogRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements IGeneralService<Blog> {

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

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRipository.findById(id);
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


    public Blog save(Blog blog) {
        blogRipository.save(blog);
        return blog;
    }


    public void remove(Long id) {
        blogRipository.deleteById(id);
    }

    List<Blog> findByCategory(Category category){
        return blogRipository.findByCategory(category);
    };

}
