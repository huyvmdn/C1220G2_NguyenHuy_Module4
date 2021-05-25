package com.case_study.furama.model;


import com.case_study.furama.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * User Entity
 */
@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;


    @Column(name = "fullName")
    private String fullName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "numberPhone")
    private String numberPhone;

    @Column(name = "imageAvatarOfUser")
    private String imageAvatarOfUser = "avatar-default.png";

    @Column(name = "password")
    private String password;

    @Column(name = "rememberToken")
    private String rememberToken;

    @Column(name = "created_At")
    private Timestamp createdAt;

    @Column(name = "updated_At")
    private Timestamp updatedAt;


    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToOne(mappedBy ="user",cascade = CascadeType.ALL)
    private Employee employee;
}