package com.banquito.cbs.customer.repository;

import com.banquito.cbs.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
