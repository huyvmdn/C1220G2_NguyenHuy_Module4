package com.baitap.validation.entity;


import com.baitap.validation.until.Age;
import com.baitap.validation.until.UniqueEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 45)
    private String firstName;
    @Size(min = 2, max = 45)
    private String lastName;
    @Pattern(regexp = "^[0][0-9]{9,11}$")
    private String phoneNumer;

    @Age
    private Long age;

    @Email
    @UniqueEmail
    private String email;

}
