package com.example.demo.service;

import com.example.demo.model.TierHistoryRecord;
import java.util.List;
public interface TierUpgradeEngineService {
    String evaluateAndUpgradeTier(Long id); // Return String, not TierHistoryRecord
}