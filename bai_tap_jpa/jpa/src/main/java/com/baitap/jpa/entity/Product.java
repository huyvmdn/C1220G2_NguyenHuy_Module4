package com.baitap.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String name;
    private Double price;
    private Long stock;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="detail_id", nullable=false)
    private  Detail detail;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "product_cart", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private List<Cart> carts;

    public Product(String name, Double price, Long stock, Detail detail, Category category, List<Cart> carts ) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.detail = detail;
        this.category = category;
        this.carts = carts;
    }

    public Product(String name, Double price, Long stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

}
