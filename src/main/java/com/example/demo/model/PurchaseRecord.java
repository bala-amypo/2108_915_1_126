package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;
    
    @ManyToOne // The test expects a Customer object reference
    private CustomerProfile customer; 

    public void setId(long id) { this.id = id; }
    public Long getId() { return id; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
    public void setPurchaseDate(LocalDate date) { this.purchaseDate = date; }
    public void setStoreLocation(String loc) { this.storeLocation = loc; }
}