package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String customerId;
    private String fullName;
    private String email;
    private String phone;
    private String currentTier = "BRONZE";
    private boolean active = true; //
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now(); //
    }

    // Standard Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isActive() { return active; }
    
    // This fixes the "cannot find symbol: method setActive(boolean)" error
    public void setActive(boolean active) { 
        this.active = active; 
    }

    // Ensure you have these for other logic
    public String getCurrentTier() { return currentTier; }
    public void setCurrentTier(String currentTier) { this.currentTier = currentTier; }
}