package com.baitap.blog.ripository;


import com.baitap.blog.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRipository extends JpaRepository<Category,Long> {

}
