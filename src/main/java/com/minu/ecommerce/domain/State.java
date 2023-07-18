package com.minu.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "state")
@Getter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
