package com.baitap.jpa.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String content;

    @OneToOne(mappedBy ="detail",cascade = CascadeType.ALL)
    private Product product;

    public Detail(String image, String content) {
        this.image = image;
        this.content = content;
    }
}
