package com.example.demo.repository;

import com.example.demo.model.VisitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface VisitRecordRepository extends JpaRepository<VisitRecord, Long> {
    // Parameter must be Long to match the updated Entity field
    List<VisitRecord> findByCustomerId(Long customerId);

    // This method must also use Long for the count aggregation
    Long countByCustomerId(Long customerId);
}