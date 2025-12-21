package com.example.demo.repository;

import com.example.demo.model.CustomerProfile;
import com.example.demo.model.TierUpgradeRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
    Optional<CustomerProfile> findByCustomerId(String customerId);
}
