package com.example.demo.service;

import com.example.demo.model.TierUpgradeRule;
import java.util.List;

public interface TierUpgradeRuleService {

    TierUpgradeRule createRule(TierUpgradeRule rule);

    TierUpgradeRule update(Long id, TierUpgradeRule rule);

    List<TierUpgradeRule> getAll();

    TierUpgradeRule getById(Long id);

    void delete(Long id);
}
