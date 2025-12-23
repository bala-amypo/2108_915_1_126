package com.example.demo.service.impl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.TierHistoryRecordRepository;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final TierHistoryRecordRepository repo;

    public TierUpgradeEngineServiceImpl(TierHistoryRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public String evaluateAndUpgradeTier(Long customerId) {
        return "Tier evaluation completed for customer " + customerId;
    }

    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return repo.findAll();
    }
}
