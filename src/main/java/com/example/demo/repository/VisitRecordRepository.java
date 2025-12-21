package com.example.demo.repository;

import com.example.demo.model.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
    // Add this line to fix the final compilation error
    List<VisitRecord> findByCustomerId(Long customerId);

    // Existing count method for the upgrade engine
    Long countByCustomerId(Long customerId);
}