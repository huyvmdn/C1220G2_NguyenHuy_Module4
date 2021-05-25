package com.case_study.furama.dto;


import com.case_study.furama.model.User;
import com.case_study.furama.model.entity.Division;
import com.case_study.furama.model.entity.EducationDegree;
import com.case_study.furama.model.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String birthday;

    @NotBlank
    @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "9 số hoặc 12 số (X là số từ 0-9)")
    private String idCard;

    @Min(value = 0)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private double salary;
    @NotBlank
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;
    @Email
    private String email;

    private String address;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    private User user;


}
