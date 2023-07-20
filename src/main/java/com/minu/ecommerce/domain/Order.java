package com.minu.ecommerce.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    @Setter
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    @Setter
    private int totalQuantity;

    @Column(name = "total_price")
    @Setter
    private BigDecimal totalPrice;
    @Column(name = "status")
    @Setter
    private String status;
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Setter
    private Customer customer;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    @Setter
    private Address shippingAddress;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    @Setter
    private Address billingAddress;

    public void add(OrderItem item){

        if(item != null){
            if (orderItems == null){
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }
    }

}
