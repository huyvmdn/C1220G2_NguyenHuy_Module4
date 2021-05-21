package com.baitap.quan_ly_sach.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private String name;
    private String author;
    private String publishingCompany;
    private String image;
    private String introduce;
    private int stock;


    @OneToMany(mappedBy ="book",cascade = CascadeType.ALL)
    private List<RentalCode> rentalCodes;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public Book(String name, String author, String publishingCompany) {
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
    }

    public Book(String name, String author, String publishingCompany, String introduce, int stock) {
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.introduce = introduce;
        this.stock = stock;
    }



    public Book(String name, String author, String publishingCompany, String image, String introduce, int stock) {
        this.name = name;
        this.author = author;
        this.publishingCompany = publishingCompany;
        this.image = image;
        this.introduce = introduce;
        this.stock = stock;
    }
}
