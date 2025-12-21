package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;
import java.util.List;

@Service
public class TierUpgradeEngineService {
    // Exact order of dependencies as per Step 0, Constraint 5
    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    public TierUpgradeEngineService(
        CustomerProfileRepository customerRepo,
        PurchaseRecordRepository purchaseRepo,
        VisitRecordRepository visitRepo,
        TierUpgradeRuleRepository ruleRepo,
        TierHistoryRecordRepository historyRepo
    ) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Transactional
    public void evaluateAndUpgradeTier(Long id) {
        CustomerProfile customer = customerRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        // Aggregate data
        Double totalSpend = purchaseRepo.sumAmountByCustomerId(id);
        Long visitCount = visitRepo.countByCustomerId(id);

        // Logic to find next tier (Example: Bronze to Silver)
        String nextTier = determineNextTier(customer.getCurrentTier());
        
        ruleRepo.findByFromTierAndToTier(customer.getCurrentTier(), nextTier)
            .ifPresent(rule -> {
                if (totalSpend >= rule.getMinSpend() && visitCount >= rule.getMinVisits()) {
                    String oldTier = customer.getCurrentTier();
                    customer.setCurrentTier(nextTier);
                    customerRepo.save(customer);
                    
                    // Log History
                    TierHistoryRecord history = new TierHistoryRecord(
                        id, oldTier, nextTier, "Threshold met"
                    );
                    historyRepo.save(history);
                }
            });
    }

    private String determineNextTier(String current) {
        if ("BRONZE".equals(current)) return "SILVER";
        if ("SILVER".equals(current)) return "GOLD";
        return current;
    }
    // Fixes the error in TierUpgradeEngineController:26
    public List<TierHistoryRecord> getHistoryByCustomer(Long customerId) {
        return historyRepo.findByCustomerId(customerId);
    }

    // Fixes the error in TierUpgradeEngineController:31
    public List<TierHistoryRecord> getAllHistory() {
        return historyRepo.findAll();
    }
}