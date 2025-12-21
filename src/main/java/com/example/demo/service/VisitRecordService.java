package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import com.example.demo.repository.VisitRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

@Service
public class VisitRecordService {
    private final VisitRecordRepository repository;

    public VisitRecordService(VisitRecordRepository repository) {
        this.repository = repository;
    }

    public VisitRecord recordVisit(VisitRecord visit) {
        // Requirement: Validate channel in {"STORE", "APP", "WEB"}
        List<String> validChannels = Arrays.asList("STORE", "APP", "WEB");
        if (!validChannels.contains(visit.getChannel())) {
            throw new IllegalArgumentException("Invalid visit channel");
        }
        return repository.save(visit);
    }

    public List<VisitRecord> getVisitsByCustomer(Long id) {
        return repository.findByCustomerId(id);
    }
}