package com.example.demo.service.impl;

import com.example.demo.model.PurchaseRecord;
import com.example.demo.repository.PurchaseRecordRepository;
import com.example.demo.service.PurchaseRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService {

    private final PurchaseRecordRepository repo;

    public PurchaseRecordServiceImpl(PurchaseRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public PurchaseRecord recordPurchase(PurchaseRecord purchase) {
        return repo.save(purchase);
    }

    @Override
    public PurchaseRecord getPurchaseById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseRecord> getPurchasesByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public List<PurchaseRecord> getAllPurchases() {
        return repo.findAll();
    }
}
