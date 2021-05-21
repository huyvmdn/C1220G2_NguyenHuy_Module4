package com.baitap.jpa.entity;


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
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;
    private String name;
    @Column(columnDefinition = "date")
    private String orderDate;

    @ManyToMany(mappedBy = "carts", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products;
}
