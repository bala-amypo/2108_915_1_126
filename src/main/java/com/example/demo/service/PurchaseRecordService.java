package com.example.demo.service;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PurchaseRecordService {
    private final PurchaseRecordRepository repository;

    public PurchaseRecordService(PurchaseRecordRepository repository) {
        this.repository = repository;
    }

    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        if (purchase.getAmount() <= 0) {
            throw new IllegalArgumentException("Purchase Amount must be > 0"); //
        }
        return repository.save(purchase);
    }

    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repository.findByCustomerId(customerId);
    }

    public PurchaseRecord getPurchaseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Purchase not found"));
    }

    public List<PurchaseRecord> getAllPurchases() {
        return repository.findAll();
    }
}