// package com.example.demo.service.impl;

// import com.example.demo.model.CustomerProfile;
// import com.example.demo.repository.CustomerProfileRepository;
// import com.example.demo.service.CustomerProfileService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CustomerProfileServiceImpl implements CustomerProfileService {

//     private final CustomerProfileRepository repo;

//     public CustomerProfileServiceImpl(CustomerProfileRepository repo) {
//         this.repo = repo;
//     }

//     @Override
//     public CustomerProfile createCustomer(CustomerProfile customer) {
//         return repo.save(customer);
//     }

//     @Override
//     public CustomerProfile getCustomerById(Long id) {
//         return repo.findById(id).orElse(null);
//     }

//     @Override
//     public CustomerProfile findByCustomerId(String customerId) {
//         return repo.findByCustomerId(customerId).orElse(null);
//     }

//     @Override
//     public List<CustomerProfile> getAllCustomers() {
//         return repo.findAll();
//     }

//     @Override
//     public CustomerProfile updateTier(Long id, String newTier) {
//         CustomerProfile customer = repo.findById(id).orElse(null);
//         if (customer != null) {
//             customer.setCurrentTier(newTier);
//             return repo.save(customer);
//         }
//         return null;
//     }
// }
