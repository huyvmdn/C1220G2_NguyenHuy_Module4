package com.trungdoan.demosecurity.service;


import com.trungdoan.demosecurity.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findByTitleContaining(String string, Pageable pageable);
    Iterable<Blog> findtitle(String search);
}
