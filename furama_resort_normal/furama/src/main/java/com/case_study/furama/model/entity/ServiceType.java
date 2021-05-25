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
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceType_id")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private List<EntityService> entityServices;

    public ServiceType(String name) {
        this.name = name;
    }
}
