package com.example.demo.ripository;

import com.example.demo.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Ripository extends JpaRepository<Blog,Integer> {

}
