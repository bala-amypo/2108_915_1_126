// package com.example.demo.service.impl;

// import com.example.demo.model.TierUpgradeRule;
// import com.example.demo.repository.TierUpgradeRuleRepository;
// import com.example.demo.service.TierUpgradeRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TierUpgradeRuleServiceImpl implements TierUpgradeRuleService {

//     private final TierUpgradeRuleRepository repo;

//     public TierUpgradeRuleServiceImpl(TierUpgradeRuleRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public TierUpgradeRule createRule(TierUpgradeRule rule) {
//         return repo.save(rule);
//     }

//     @Override
//     public TierUpgradeRule update(Long id, TierUpgradeRule rule) {
//         rule.setId(id);
//         return repo.save(rule);
//     }

//     @Override
//     public List<TierUpgradeRule> getAll() {
//         return repo.findAll();
//     }

//     @Override
//     public TierUpgradeRule getById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public void delete(Long id) {
//         repo.deleteById(id);
//     }
// }
