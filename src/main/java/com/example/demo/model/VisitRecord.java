package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {
    @Id // This was likely missing or not imported correctly
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerId; // Use String to match findByCustomerId(String id) requirements
    private LocalDate visitDate;
    private String channel;

    @ManyToOne
    @JoinColumn(name = "customer_internal_id")
    private CustomerProfile customer;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
    
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}