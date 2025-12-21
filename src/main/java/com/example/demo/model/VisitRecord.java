package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class VisitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Change this from String to Long to match the Repository signature
    private Long customerId; 
    
    private LocalDate visitDate;
    private String channel;

    // Standard getters and setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}