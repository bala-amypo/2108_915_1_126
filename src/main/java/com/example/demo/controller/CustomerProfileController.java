package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
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
        return service.getCustomerById(id);
    }

    @GetMapping("/lookup/{customerId}")
    public CustomerProfile getByCustomerId(@PathVariable String customerId) {
        return service.findByCustomerId(customerId);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return service.getAllCustomers();
    }

    @PutMapping("/{id}/tier")
    public CustomerProfile updateTier(@PathVariable Long id,
                                      @RequestParam String newTier) {
        return service.updateTier(id, newTier);
    }
}
