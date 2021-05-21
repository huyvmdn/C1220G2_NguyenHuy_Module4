package com.baitap.jpa.repository;

import com.baitap.jpa.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRipository extends JpaRepository<Category,Long> {

}
