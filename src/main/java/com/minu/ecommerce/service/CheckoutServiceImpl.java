package com.minu.ecommerce.service;

import com.minu.ecommerce.domain.Customer;
import com.minu.ecommerce.domain.Order;
import com.minu.ecommerce.domain.OrderItem;
import com.minu.ecommerce.dto.PurchaseRequest;
import com.minu.ecommerce.dto.PurchaseResponse;
import com.minu.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{
    private final CustomerRepository customerRepository;


    @Override
    @Transactional
    public PurchaseResponse placeOrder(PurchaseRequest purchaseRequest) {
        Order order = purchaseRequest.getOrder();

        // 주문번호 생성
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //아이템 매핑
        Set<OrderItem> orderItems = purchaseRequest.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        order.setShippingAddress(purchaseRequest.getShippingAddress());
        order.setBillingAddress(purchaseRequest.getBillingAddress());


        // 고객과 주문을 매핑
        Customer customer = purchaseRequest.getCustomer();
        customer.add(order);

        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // 랜덤 값 생성 UUID
        return UUID.randomUUID().toString();

    }
}
