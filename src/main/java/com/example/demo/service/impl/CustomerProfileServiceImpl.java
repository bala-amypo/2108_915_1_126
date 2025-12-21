package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerProfileRepository repository;

    // Requirement: Strict Constructor Injection
    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    // Fixes the error regarding missing updateTier
    @Override
    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        customer.setCurrentTier(newTier);
        repository.save(customer);
    }

    // Fixes the error regarding missing updateStatus
    @Override
    public void updateStatus(Long id, boolean active) {
        CustomerProfile customer = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        customer.setActive(active);
        repository.save(customer);
    }

    // Ensure all other required methods from the interface are implemented
    @Override
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    @Override
    public Optional<CustomerProfile> getCustomerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<CustomerProfile> findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId);
    }
}