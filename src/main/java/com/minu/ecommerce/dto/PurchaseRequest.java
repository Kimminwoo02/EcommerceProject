package com.minu.ecommerce.dto;

import com.minu.ecommerce.domain.Address;
import com.minu.ecommerce.domain.Customer;
import com.minu.ecommerce.domain.Order;
import com.minu.ecommerce.domain.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class PurchaseRequest {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;



}
