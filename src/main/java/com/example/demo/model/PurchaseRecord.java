package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    @ManyToOne
    @JoinColumn(name = "customer_internal_id")
    private CustomerProfile customer;

    // Helper for your existing logic
    private Long customerId; 

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public void setCustomer(CustomerProfile customer) { 
        this.customer = customer; 
        if (customer != null) this.customerId = customer.getId();
    }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setStoreLocation(String storeLocation) { this.storeLocation = storeLocation; }
}