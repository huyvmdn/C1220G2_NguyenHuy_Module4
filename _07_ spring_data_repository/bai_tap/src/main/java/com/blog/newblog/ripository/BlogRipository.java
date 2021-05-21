package com.blog.newblog.ripository;

import com.blog.newblog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRipository extends JpaRepository<Blog,Long> {
    Page<Blog> findAllByTitleContaining(String search, Pageable pageable);
    List<Blog> findAllByCategoryId(Integer id);

    @Query(value=" select * from blog b order by b.date_blog" , nativeQuery = true )
    List<Blog> sort ();
}
