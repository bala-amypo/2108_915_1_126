// package com.example.demo.repository;

// import com.example.demo.model.PurchaseRecord;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import java.util.List;

// public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Long> {
//     // Add this line to fix the PurchaseRecordService error
//     List<PurchaseRecord> findByCustomerId(Long customerId);

//     @Query("SELECT COALESCE(SUM(p.amount), 0.0) FROM PurchaseRecord p WHERE p.customerId = :customerId")
//     Double sumAmountByCustomerId(@Param("customerId") Long customerId);
// }