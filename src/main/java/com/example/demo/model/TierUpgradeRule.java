package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class TierUpgradeRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromTier;
    private String toTier;
    private Double minSpend;
    private Integer minVisits;

    // Getters and Setters
    public String getFromTier() { return fromTier; }
    public String getToTier() { return toTier; }
    public Double getMinSpend() { return minSpend; }
    public Integer getMinVisits() { return minVisits; }
}