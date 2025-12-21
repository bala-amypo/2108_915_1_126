package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import com.example.demo.repository.TierUpgradeRuleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TierUpgradeRuleService {
    private final TierUpgradeRuleRepository repository;

    public TierUpgradeRuleService(TierUpgradeRuleRepository repository) {
        this.repository = repository;
    }

    public TierUpgradeRule createRule(TierUpgradeRule rule) {
        return repository.save(rule);
    }

    public List<TierUpgradeRule> getActiveRules() {
        return repository.findAll().stream()
                .filter(TierUpgradeRule::isActive)
                .collect(Collectors.toList());
    }

    public TierUpgradeRule getRule(String fromTier, String toTier) {
        return repository.findByFromTierAndToTier(fromTier, toTier)
                .orElseThrow(() -> new NoSuchElementException("Rule not found"));
    }
}