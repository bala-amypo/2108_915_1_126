package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private Double amount;
    private LocalDate purchaseDate;
    private String storeLocation;

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
    public Long getCustomerId() { return customerId; }
}