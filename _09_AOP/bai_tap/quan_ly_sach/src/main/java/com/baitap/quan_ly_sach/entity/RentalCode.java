package com.baitap.quan_ly_sach.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalCode_id")
    private Long id;
    private String idcard;
    private String codeRentalCode;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    public RentalCode(String idcard, String codeRentalCode, Book book) {
        this.idcard = idcard;
        this.codeRentalCode = codeRentalCode;
        this.book = book;
    }

    public RentalCode(String idcard) {
        this.idcard = idcard;
    }
}
