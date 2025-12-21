package com.example.demo.service.impl;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import com.example.demo.service.CustomerProfileService;
import org.springframework.stereotype.Service; // Fixed Missing @Service
import java.util.List;
import java.util.Optional;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService {
    private final CustomerProfileRepository repository;

    public CustomerProfileServiceImpl(CustomerProfileRepository repository) {
        this.repository = repository;
    }
    // Implement methods...
}