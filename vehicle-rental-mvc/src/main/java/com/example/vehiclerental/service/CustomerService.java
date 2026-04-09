package com.example.vehiclerental.service;

import com.example.vehiclerental.entity.Customer;
import com.example.vehiclerental.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() { return customerRepository.findAll(); }
    public Customer save(Customer customer) { return customerRepository.save(customer); }
    public Customer findById(Long id) { return customerRepository.findById(id).orElseThrow(); }
    public void deleteById(Long id) { customerRepository.deleteById(id); }
}
