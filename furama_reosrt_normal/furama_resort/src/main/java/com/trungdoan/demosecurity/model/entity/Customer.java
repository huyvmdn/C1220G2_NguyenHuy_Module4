package com.trungdoan.demosecurity.model.entity;


import com.trungdoan.demosecurity.ultil.CustomerEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "KH-XXXX (X là số từ 0-9)")
    private String code;

    @NotBlank
    private String name;
    @NotBlank
    @Column(columnDefinition = "date")
    private String birthday;
    @NotNull
    @Column(columnDefinition = "Boolean")
    private boolean gender;
    @NotBlank
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "9 số hoặc 12 số (X là số từ 0-9)")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email
    @CustomerEmail
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "customerType_id", nullable = false)
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer(@NotBlank @Pattern(regexp = "^KH-[0-9]{4}$", message = "KH-XXXX (X là số từ 0-9)") String code, @NotBlank String name, @NotBlank String birthday, @NotNull boolean gender, @NotBlank @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "KH-XXXX (X là số từ 0-9)") String idCard, @NotBlank @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx") String phone, @Email @NotEmpty String email, String address, CustomerType customerType) {
        this.code = code;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }
}
