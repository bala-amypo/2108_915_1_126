package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "CustomerProfileController")
public class CustomerProfileController {
    private final CustomerProfileService service;

    public CustomerProfileController(CustomerProfileService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        return service.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomer(@PathVariable Long id) {
        // Fixes incompatible types: Optional to CustomerProfile
        return service.getCustomerById(id)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
    }

    @GetMapping
    public List<CustomerProfile> listAll() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public void updateTier(@PathVariable Long id, @RequestParam String tier) {
        service.updateTier(id, tier);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile lookup(@PathVariable String customerId) {
        // Fixes incompatible types: Optional to CustomerProfile
        return service.findByCustomerId(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer ID not found"));
    }
}