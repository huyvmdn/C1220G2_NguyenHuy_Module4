package com.trungdoan.demosecurity.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @NotBlank
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "KH-XXXX (X là số từ 0-9)")
    @Column(name = "customer_id")
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private LocalDate birthday;
    @NotBlank
    private boolean gender;
    @NotBlank
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "KH-XXXX (X là số từ 0-9)")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name="customerType_id", nullable=false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer(@NotBlank @Pattern(regexp = "^KH-[0-9]{4}$", message = "KH-XXXX (X là số từ 0-9)") Long id, @NotBlank String name, @NotBlank LocalDate birthday, @NotBlank boolean gender, @NotBlank @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "KH-XXXX (X là số từ 0-9)") String idCard, @NotBlank @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx") String phone, @Email String email, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }


}
