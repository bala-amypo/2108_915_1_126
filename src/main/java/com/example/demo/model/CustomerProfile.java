package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Required for PurchaseRecord logic
    
    private String currentTier = "BRONZE"; // Required for TierUpgradeEngine logic

    // ... other fields like fullName, email, active, etc.

    // ADD THESE SPECIFIC METHODS
    public Long getId() { 
        return id; 
    }

    public String getCurrentTier() { 
        return currentTier; 
    }

    public void setCurrentTier(String currentTier) { 
        this.currentTier = currentTier; 
    }
}