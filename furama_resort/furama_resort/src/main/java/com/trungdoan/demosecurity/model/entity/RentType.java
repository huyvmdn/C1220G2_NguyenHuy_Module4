package com.trungdoan.demosecurity.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentType_id")
    private Long id;
    private String name;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double cost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private List<EntityService> entityServices;

    public RentType(String name) {
        this.name = name;
    }
}
