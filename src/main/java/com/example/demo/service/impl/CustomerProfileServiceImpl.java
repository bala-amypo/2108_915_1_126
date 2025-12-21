package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException; //

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    // Fixes the first ERROR: Missing implementation of updateTier
    @Override
    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found")); //
        customer.setCurrentTier(newTier);
        repository.save(customer);
    }

    @Override
    public void updateStatus(Long id, boolean active) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found")); //
        customer.setActive(active); // This now works with the fix in step 1
        repository.save(customer);
    }
    
    // Implement other required methods (createCustomer, getCustomerById, etc.)
}