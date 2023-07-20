package com.minu.ecommerce.service;

import com.minu.ecommerce.dto.PurchaseRequest;
import com.minu.ecommerce.dto.PurchaseResponse;
import org.springframework.stereotype.Service;


public interface CheckoutService {
    PurchaseResponse placeOrder(PurchaseRequest purchaseRequest);
}
