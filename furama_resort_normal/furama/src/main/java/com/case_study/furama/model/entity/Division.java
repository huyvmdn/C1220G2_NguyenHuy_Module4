package com.case_study.furama.model.entity;

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
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Division(String name) {
        this.name = name;
    }

    public Division(Long id) {
        this.id = id;
    }
}
