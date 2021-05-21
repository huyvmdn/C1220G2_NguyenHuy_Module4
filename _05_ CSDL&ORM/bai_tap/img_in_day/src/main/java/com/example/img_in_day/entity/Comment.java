package com.example.img_in_day.entity;

import javax.persistence.*;

@Entity @Table(name = "comment_tbl")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int star;
    private String name;
    private String feedback;

    public Comment() {
    }


    public Comment(int star, String name, String feedback) {
        this.star = star;
        this.name = name;
        this.feedback = feedback;
    }

    public Comment(int star, String name) {
        this.star = star;
        this.name = name;
    }

    public Comment(int star) {
        this.star = star;
        this.name= "unknow";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
