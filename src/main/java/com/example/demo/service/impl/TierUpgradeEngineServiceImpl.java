package com.example.demo.service.impl;

import com.example.demo.model.TierHistoryRecord;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final TierHistoryRecordRepository historyRepo;
    // ... other repositories (customerRepo, purchaseRepo, etc.)

    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo) {
        // ... assignments
        this.historyRepo = historyRepo;
    }

    // This fixes the current compilation error
    @Override
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }

    // Ensure this is also present to match the interface
    @Override
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    @Override
    public void evaluateAndUpgradeTier(Long customerId) {
        // ... existing logic
    }
}