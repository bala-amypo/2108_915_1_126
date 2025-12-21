package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException; // Required constraint
import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    // Requirement: Strict Constructor Injection
    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    // This fixes the final compilation error
    @Override
    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found")); // Required exception
        customer.setCurrentTier(newTier);
        repository.save(customer);
    }

    // Ensure all other interface methods are implemented...
    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }
    
    // ... createCustomer, getCustomerById, etc.
}