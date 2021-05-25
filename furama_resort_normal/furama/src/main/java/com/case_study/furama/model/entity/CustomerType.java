package com.case_study.furama.model.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor(staticName = "name")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerType_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private List<Customer> customers;

    public CustomerType(String name) {
        this.name = name;
    }

    public CustomerType(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
