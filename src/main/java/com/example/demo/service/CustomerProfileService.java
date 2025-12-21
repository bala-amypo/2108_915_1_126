package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;
import java.util.Optional;

public interface CustomerProfileService {
    CustomerProfile createCustomer(CustomerProfile customer);
    Optional<CustomerProfile> getCustomerById(Long id); // Test expects isPresent()
    Optional<CustomerProfile> findByCustomerId(String customerId);
    List<CustomerProfile> getAllCustomers();
    void updateTier(Long id, String newTier);
    void updateStatus(Long id, boolean active);
}