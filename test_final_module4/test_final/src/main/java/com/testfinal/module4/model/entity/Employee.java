package com.testfinal.module4.model.entity;


import com.testfinal.module4.model.security.User;
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
    @Column(columnDefinition = "date")
    @Pattern(regexp = "^([12][09][0-9]{2}/[01][0-9]/[0123][0-9])$", message = "dd/mm/yyyy and 1900 - 2099")
    private String birthday;

    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @Email
    private String email;

    private String address;

//    @ManyToOne
//    @JoinColumn(name="position_id", nullable=false)
//    private Position position;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="userId", nullable=false)
    private User user;
}
