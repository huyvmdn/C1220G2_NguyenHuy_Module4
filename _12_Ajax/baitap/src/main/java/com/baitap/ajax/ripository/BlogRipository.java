package com.baitap.ajax.ripository;


import com.baitap.ajax.entity.Blog;
import com.baitap.ajax.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRipository extends JpaRepository<Blog,Long> {

    @Query(value = " select *\n" +
            "from blog\n" +
            "where title like %?1% ",nativeQuery = true)
    Iterable<Blog> findtitle(String search);


    Page<Blog> findByTitleContaining(String search,Pageable pageable);

    List<Blog> findAllByCategoryId(Integer id);
    List<Blog> findByCategory(Category category);
    @Query(value=" select * from blog b order by b.date_blog" , nativeQuery = true )
    List<Blog> sort ();
}
