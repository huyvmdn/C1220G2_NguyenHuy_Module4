package com.case_study.furama.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntityService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @NotBlank
    @Pattern(regexp = "^DV-[0-9]{4}$", message = "DV-XXXX (X là số từ 0-9)")
    private String code;

    private String name;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int area;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
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

    @OneToMany(mappedBy = "entityService", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    @ManyToOne
    @JoinColumn(name="rentType_id", nullable=false)
    private RentType rentType;

    public EntityService(@NotBlank @Pattern(regexp = "^DV-[0-9]{4}$", message = "DV-XXXX (X là số từ 0-9)") String code, String name, @Min(value = 0) int area, @Min(value = 0) double cost, @Min(value = 0) int maxPeople, String standardRoom, String descriptionOtherConvenience, @Min(value = 0) double poolArea, @Min(value = 0) int numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.code = code;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }
}
