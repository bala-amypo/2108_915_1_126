package com.example.demo.repository;

import com.example.demo.model.PurchaseRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
    @Query("SELECT COALESCE(SUM(p.amount), 0.0) FROM PurchaseRecord p WHERE p.customerId = :customerId")
    Double sumAmountByCustomerId(@Param("customerId") Long customerId);
}