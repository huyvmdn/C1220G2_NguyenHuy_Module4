package com.trungdoan.demosecurity.model.entity;


import com.trungdoan.demosecurity.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private LocalDate birthday;
    @NotBlank
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "KH-XXXX (X là số từ 0-9)")
    private String id_card;
    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.PERCENT)
    private double salary;
    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name="position_id", nullable=false)
    private Position position;

    @ManyToOne
    @JoinColumn(name="educationDegree_id", nullable=false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name="division_id", nullable=false)
    private Division division;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="userId", nullable=false)
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contracts;
}
