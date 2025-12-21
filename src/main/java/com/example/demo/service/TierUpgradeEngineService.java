package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TierUpgradeEngineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeEngineServiceImpl implements TierUpgradeEngineService {

    private final CustomerProfileRepository customerRepo;
    private final PurchaseRecordRepository purchaseRepo;
    private final VisitRecordRepository visitRepo;
    private final TierUpgradeRuleRepository ruleRepo;
    private final TierHistoryRecordRepository historyRepo;

    // Strict constructor injection order as per requirements
    public TierUpgradeEngineServiceImpl(
            CustomerProfileRepository customerRepo,
            PurchaseRecordRepository purchaseRepo,
            VisitRecordRepository visitRepo,
            TierUpgradeRuleRepository ruleRepo,
            TierHistoryRecordRepository historyRepo) {
        this.customerRepo = customerRepo;
        this.purchaseRepo = purchaseRepo;
        this.visitRepo = visitRepo;
        this.ruleRepo = ruleRepo;
        this.historyRepo = historyRepo;
    }

    @Override
    @Transactional
    public void evaluateAndUpgradeTier(Long customerId) {
        CustomerProfile customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        // 1. Aggregate Data
        Double totalSpend = purchaseRepo.sumAmountByCustomerId(customerId);
        Long totalVisits = visitRepo.countByCustomerId(customerId);
        String currentTier = customer.getCurrentTier();

        // 2. Determine Next Tier
        String targetTier = determineTargetTier(currentTier);
        
        // 3. Check Rules
        ruleRepo.findByFromTierAndToTier(currentTier, targetTier)
                .filter(TierUpgradeRule::isActive)
                .ifPresent(rule -> {
                    if (totalSpend >= rule.getMinSpend() && totalVisits >= rule.getMinVisits()) {
                        performUpgrade(customer, currentTier, targetTier);
                    }
                });
    }

    private String determineTargetTier(String current) {
        return switch (current) {
            case "BRONZE" -> "SILVER";
            case "SILVER" -> "GOLD";
            default -> current;
        };
    }

    private void performUpgrade(CustomerProfile customer, String oldTier, String newTier) {
        customer.setCurrentTier(newTier);
        customerRepo.save(customer);

        TierHistoryRecord history = new TierHistoryRecord();
        history.setCustomerId(customer.getId());
        history.setOldTier(oldTier);
        history.setNewTier(newTier);
        history.setReason("Tier evaluation: Spend and Visit thresholds met");
        historyRepo.save(history);
    }
}