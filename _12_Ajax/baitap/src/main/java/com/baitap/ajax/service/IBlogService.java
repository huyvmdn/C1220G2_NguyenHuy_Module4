package com.baitap.ajax.service;

import com.baitap.ajax.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findByTitleContaining(String string,Pageable pageable);
    Iterable<Blog> findtitle(String search);
}
