package com.example.img_in_day.ripository;

import com.example.img_in_day.entity.Comment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class CmtRipository {

    @PersistenceContext
    private EntityManager em;

     public List<Comment> countStar() {
        TypedQuery<Comment> query=em.createQuery(" select :star, count(star) as count from Comment group by star", Comment.class);

        return query.getResultList();
    }
}
