package com.thuchanh.i18n.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Component
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "provinces", nullable = false, referencedColumnName = "province_id")
    private Province province;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.province = province;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}