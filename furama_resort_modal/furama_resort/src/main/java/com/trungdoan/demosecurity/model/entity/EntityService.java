package com.trungdoan.demosecurity.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityService {

    @Id
    @NotBlank
    @Pattern(regexp = "^DV-[0-9]{4}$", message = "DV-XXXX (X là số từ 0-9)")
    @Column(name = "service_id")
    private String id;
    private String name;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int area;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double cost;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @Min(value = 0)
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double poolArea;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int numberOfFloors;

    @ManyToOne
    @JoinColumn(name="serviceType_id", nullable=false)
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name="rentType_id", nullable=false)
    private RentType rentType;

}
