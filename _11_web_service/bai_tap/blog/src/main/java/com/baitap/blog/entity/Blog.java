package com.baitap.blog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(200)")
    private String title;
    private String content;
    @Column(columnDefinition = "date")
    private String dateBlog;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    @JoinColumn(name="category_id", nullable=false)
    @JsonBackReference
    private Category category;
//
    public Blog() {
    }

    public Blog(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Blog(Long id) {
        this.id = id;
    }

    public Blog(String content, String dateBlog) {
        this.content = content;
        this.dateBlog = dateBlog;
    }

    public Blog(Long id, String title, String dateBlog) {
        this.id = id;
        this.title = title;
        this.dateBlog = dateBlog;
    }

    public Blog(String title, String content, String dateBlog, Category category) {
        this.title = title;
        this.content = content;
        this.dateBlog = dateBlog;
        this.category = category;
    }

    public Blog(Long id, String title, String content, String dateBlog, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateBlog = dateBlog;
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(String dateBlog) {
        this.dateBlog = dateBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
