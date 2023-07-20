package com.minu.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    @Setter
    private String street;
    @Column(name = "city")
    @Setter
    private String city;
    @Column(name = "state")
    @Setter
    private String state;
    @Column(name = "country")
    @Setter
    private String country;
    @Column(name = "zip_code")
    @Setter
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;

}
