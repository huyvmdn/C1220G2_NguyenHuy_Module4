package com.trungdoan.demosecurity.service.imp;





import com.trungdoan.demosecurity.entity.Blog;
import com.trungdoan.demosecurity.entity.Category;
import com.trungdoan.demosecurity.repository.BlogRipository;
import com.trungdoan.demosecurity.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BlogService implements IBlogService {

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

    public Iterable<Blog> findtitle(String search) {
       return blogRipository.findtitle(search);
    }
    public Page<Blog> findByTitleContaining(String search, Pageable pageable) {
        return blogRipository.findByTitleContaining(search,pageable);
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


    public void deleteById(Long id) {
        blogRipository.deleteById(id);
    }

    List<Blog> findByCategory(Category category){
        return blogRipository.findByCategory(category);
    };


}
