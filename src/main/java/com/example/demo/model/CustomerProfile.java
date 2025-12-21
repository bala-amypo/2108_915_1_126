package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // ... other fields (customerId, fullName, etc.)
    
    private boolean active = true; //

    // Required by CustomerProfileServiceImpl.java:[26,17]
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    
    // Ensure you also have the setter for currentTier
    public void setCurrentTier(String currentTier) {
        this.currentTier = currentTier;
    }
}