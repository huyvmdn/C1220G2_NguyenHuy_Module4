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
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachService_id")
    private Long id;
    private String name;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double cost;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int unit;
    private boolean status;

    @OneToMany(mappedBy = "attachService", cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;

    public AttachService(String name, @Min(value = 0) double cost, @Min(value = 0) int unit, boolean status, List<ContractDetail> contractDetails) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public AttachService(String name, @Min(value = 0) double cost, @Min(value = 0) int unit, boolean status) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
    }
}
