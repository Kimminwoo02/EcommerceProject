package com.minu.ecommerce.repository;

import com.minu.ecommerce.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByEmail(String theEmail);

}
