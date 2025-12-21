package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerProfileService {
    private final CustomerProfileRepository repository;

    // Strict constructor injection
    public CustomerProfileService(CustomerProfileRepository repository) {
        this.repository = repository;
    }

    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found")); //
    }

    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    public CustomerProfile findByCustomerId(String customerId) {
        return repository.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer ID not found")); //
    }

    public void updateTier(Long id, String newTier) {
        CustomerProfile customer = getCustomerById(id);
        customer.setCurrentTier(newTier);
        repository.save(customer);
    }
}