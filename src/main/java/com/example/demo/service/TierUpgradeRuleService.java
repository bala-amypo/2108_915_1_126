package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class TierUpgradeRuleService {
    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleService(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }
}