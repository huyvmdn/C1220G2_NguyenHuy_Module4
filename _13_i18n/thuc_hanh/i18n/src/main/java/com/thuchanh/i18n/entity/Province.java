package com.thuchanh.i18n.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "provinces")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL) // truyen vao ten doi tuong ben lop Customer
    private List<Customer> customer;

    public Province() {
    }

    public Province(Integer id, String name, List<Customer> customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}