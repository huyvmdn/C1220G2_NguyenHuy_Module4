package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;


public class Admin {

    private final Integer id;
    private final String name;

    public Admin(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
