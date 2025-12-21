package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String currentTier = "BRONZE";

    // IMPORTANT: Add these for the Service to work
    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String tier) { this.currentTier = tier; }
    public Long getId() { return id; }
    // Add other getters/setters as needed...
}