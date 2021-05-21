package com.example.img_in_day.ripository;

import com.example.img_in_day.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRipository extends JpaRepository<Comment,Integer> {

    @Query("select c from Comment c ")
     List<Comment> show() ;


    @Query(" select star, count(star) as count from Comment group by star")
    List<Comment> countbyStar();

    @Query("SELECT c FROM Comment c WHERE c.id = ?1")
    Comment findId(int id) ;

    @Query("SELECT c FROM Comment c WHERE c.name = ?1")
    List<Comment> findByName(String name);


}

