package com.example.demo.controller;

import com.example.demo.model.VisitRecord;
import com.example.demo.service.VisitRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitRecordController {

    private final VisitRecordService service;

    public VisitRecordController(VisitRecordService service) {
        this.service = service;
    }

    @PostMapping
    public VisitRecord create(@RequestBody VisitRecord visit) {
        return service.create(visit);
    }

    @GetMapping("/{id}")
    public VisitRecord getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<VisitRecord> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
