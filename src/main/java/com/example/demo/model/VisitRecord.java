package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VisitRecord {
    private String channel;
    // Fixed: Added missing getter for VisitRecordService:[20,42]
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
}