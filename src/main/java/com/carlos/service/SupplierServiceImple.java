package com.carlos.service;

import com.carlos.model.Supplier;
import com.carlos.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImple implements SupplierService{
    @Autowired
    SupplierRepository repository;
    @Override
    public List<Supplier> getAllSupplier() {
        return repository.findAll();
    }

    @Override
    public Optional<Supplier> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Object[]> findCheapestItemsPerSupplier() {
        return repository.findCheapestItemsPerSupplier();
    }

    @Override
    public List<Object[]> suppliers_Associated_with_Items() {
        return repository.suppliers_Associated_with_Items();
    }
}
