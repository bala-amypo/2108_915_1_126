package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
    
    private final CustomerProfileRepository repository;

    // Requirement: Constructor Injection
    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    // This fixes the "does not override abstract method getAllCustomers()" error
    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll(); //
    }

    @Override
    public void updateStatus(Long id, boolean active) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found")); //
        customer.setActive(active);
        repository.save(customer);
    }

    // Ensure all other interface methods are implemented...
}