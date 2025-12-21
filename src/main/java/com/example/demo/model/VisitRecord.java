package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Type must match the Long ID used in the Repository findByCustomerId method
    private Long customerId; 
    
    private LocalDate visitDate;
    private String channel;

    @ManyToOne
    @JoinColumn(name = "customer_internal_id")
    private CustomerProfile customer;

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public LocalDate getVisitDate() { return visitDate; }
    public void setVisitDate(LocalDate visitDate) { this.visitDate = visitDate; }

    // This fixes the "cannot find symbol: method getChannel()" error
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}