package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {
    // ... existing fields
    @ManyToOne
    private CustomerProfile customer;

    // Fixes [105,10] and [114,10]
    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }
}