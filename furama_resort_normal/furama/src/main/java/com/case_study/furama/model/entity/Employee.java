package com.case_study.furama.model.entity;


import com.case_study.furama.model.User;
import com.case_study.furama.ultil.EmployeeEmail;
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
    @Column(columnDefinition = "date")
    @Pattern(regexp = "^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$", message = "dd/mm/yyyy and 1900 - 2099")
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
    @EmployeeEmail
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

    public Employee(@NotBlank String name, @NotBlank String birthday, @NotBlank @Pattern(regexp = "^([0-9]{9}|[0-9]{12})$", message = "KH-XXXX (X là số từ 0-9)") String idCard, @Min(value = 0) double salary, @NotBlank @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$", message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx") String phone, @Email String email, String address, Position position, EducationDegree educationDegree, Division division, User user) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }


}
