package com.example.demo.service;

import com.example.demo.model.VisitRecord;
import java.util.List;

public interface VisitRecordService {

    VisitRecord create(VisitRecord visit);

    VisitRecord getById(Long id);

    List<VisitRecord> getAll();

    void delete(Long id);
}
