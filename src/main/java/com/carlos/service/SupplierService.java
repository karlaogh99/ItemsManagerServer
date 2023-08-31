package com.carlos.service;

import com.carlos.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SupplierService {
    public List<Supplier> getAllSupplier();
    Optional<Supplier> findById(int id);
}
