package com.trungdoan.demosecurity.dto;

import com.trungdoan.demosecurity.model.entity.CustomerType;
import com.trungdoan.demosecurity.ultil.CustomerEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    @NotBlank
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "KH-XXXX (X là số từ 0-9)")
    private String code;
    @NotBlank
    private String name;
    @NotBlank
    private String birthday;
    @NotNull
    private boolean gender;
    @NotBlank
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "9 số hoặc 12 số (X là số từ 0-9)")
    private String idCard;
    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email
    private String email;
    private String address;
    private CustomerType customerType;


}
