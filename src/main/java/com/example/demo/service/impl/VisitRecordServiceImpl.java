// package com.example.demo.service.impl;

// import com.example.demo.model.VisitRecord;
// import com.example.demo.repository.VisitRecordRepository;
// import com.example.demo.service.VisitRecordService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class VisitRecordServiceImpl implements VisitRecordService {

//     private final VisitRecordRepository repo;

//     public VisitRecordServiceImpl(VisitRecordRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public VisitRecord create(VisitRecord visit) {
//         return repo.save(visit);
//     }

//     @Override
//     public VisitRecord getById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public List<VisitRecord> getAll() {
//         return repo.findAll();
//     }

//     @Override
//     public void delete(Long id) {
//         repo.deleteById(id);
//     }
// }
