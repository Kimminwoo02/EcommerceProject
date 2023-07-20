package com.minu.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "unit_price")
    @Setter
    private BigDecimal unitPrice;

    @Column(name = "quantity")
    @Setter
    private int quantity;
    @Column(name = "product_id")
    @Setter
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @Setter
    private Order order;


}
