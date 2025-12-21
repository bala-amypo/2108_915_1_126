package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CustomerProfile {
    // ... existing fields
    public String getCustomerId() { return customerId; } // Fixes [70,72]
    public void setCustomerId(String customerId) { this.customerId = customerId; } // Fixes [46,23]
    public void setId(long id) { this.id = id; } // Fixes [258,14]
}