package com.banquito.cbs.customer.service;

import com.banquito.cbs.customer.model.Customer;
import com.banquito.cbs.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer find(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void destroy(Customer customer) {
        customerRepository.delete(customer);
    }
}
