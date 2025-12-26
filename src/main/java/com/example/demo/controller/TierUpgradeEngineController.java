// package com.example.demo.controller;

// import com.example.demo.model.TierHistoryRecord;
// import com.example.demo.service.TierUpgradeEngineService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;
// import java.util.List;

// @RestController
// @RequestMapping("/api/tier-engine")
// @Tag(name = "TierUpgradeEngineController")
// public class TierUpgradeEngineController {
//     private final TierUpgradeEngineService service;

//     public TierUpgradeEngineController(TierUpgradeEngineService service) {
//         this.service = service;
//     }

//     @PostMapping("/evaluate/{customerId}")
//     public void runEvaluation(@PathVariable Long customerId) {
//         service.evaluateAndUpgradeTier(customerId);
//     }

//     @GetMapping("/history/{customerId}")
//     public List<TierHistoryRecord> getHistory(@PathVariable Long customerId) {
//         return service.getHistoryByCustomer(customerId);
//     }

//     @GetMapping
//     public List<TierHistoryRecord> listAllHistory() {
//         return service.getAllHistory();
//     }
// }