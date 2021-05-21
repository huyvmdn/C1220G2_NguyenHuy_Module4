package com.thuchanh.cart.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Table
@Getter
@Setter

@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    @Column(columnDefinition = "date")
    private LocalDate orderDate;

    @ManyToMany(mappedBy = "carts", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Product> products;

    public Cart() {
        this.orderDate = LocalDate.now();
    }

    public Cart(Set<Product> products) {
        this.orderDate = LocalDate.now();
        this.products = products;
    }
}
