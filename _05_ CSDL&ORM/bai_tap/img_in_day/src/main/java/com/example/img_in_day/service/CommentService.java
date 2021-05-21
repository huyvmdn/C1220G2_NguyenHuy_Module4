package com.example.img_in_day.service;

import com.example.img_in_day.entity.Comment;
import com.example.img_in_day.ripository.CmtRipository;
import com.example.img_in_day.ripository.CommentRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    CommentRipository ripository;
    @Autowired
    CmtRipository cmtRipository;

    public List<Comment> findAll() {
        return ripository.findAll();
    }

    public Comment findById(int id){
        return ripository.findId(id);
    }

    public void save(Comment comment) {
        ripository.save(comment);
    }
   public void  delete(int id) {
        ripository.deleteById(id);
   }

    public List<Comment> countbyStar() { return cmtRipository.countStar();}
}
