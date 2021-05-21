package com.trungdoan.demosecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(200)")
    private String title;
    private String content;
    @Column(columnDefinition = "date")
    private LocalDate dateBlog;
    private String image;

    //    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    @JsonBackReference
    private Category category;


    public Blog(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Blog(Long id) {
        this.id = id;
    }

    public Blog(String content, LocalDate dateBlog, String image, Category category) {
        this.content = content;
        this.dateBlog = dateBlog;
        this.image = image;
        this.category = category;
    }

    public Blog(Long id, String title, String content, LocalDate dateBlog, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateBlog = dateBlog;
        this.category = category;
    }

    public Blog(String title, String content, LocalDate dateBlog, String image, Category category) {
        this.title = title;
        this.content = content;
        this.dateBlog = dateBlog;
        this.image = image;
        this.category = category;
    }
}
