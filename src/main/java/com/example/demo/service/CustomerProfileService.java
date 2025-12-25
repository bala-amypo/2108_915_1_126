package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import java.util.List;
public interface CustomerProfileService {
    CustomerProfile findByCustomerId(String customerId); // Remove Optional wrapper
    void updateStatus(Long id, boolean status);
}