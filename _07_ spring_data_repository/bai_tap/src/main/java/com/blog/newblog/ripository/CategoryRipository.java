package com.blog.newblog.ripository;

import com.blog.newblog.entity.Blog;
import com.blog.newblog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRipository extends JpaRepository<Category,Long> {

}
