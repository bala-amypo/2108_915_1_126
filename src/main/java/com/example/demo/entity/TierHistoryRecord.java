package com.example.demo.entity;
import java.time.LocalDateTime;

public class TierHistoryRecord {
    private Long id;
    private Long customerId;
    private String oldTier;
    private String newTier;
    private LocalDateTime changeDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public String getOldTier() { return oldTier; }
    public void setOldTier(String oldTier) { this.oldTier = oldTier; }
    public String getNewTier() { return newTier; }
    public void setNewTier(String newTier) { this.newTier = newTier; }
    public LocalDateTime getChangeDate() { return changeDate; }
    public void setChangeDate(LocalDateTime changeDate) { this.changeDate = changeDate; }
}