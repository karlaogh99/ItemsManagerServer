package com.carlos.service;

import com.carlos.model.ItemSupplier;
import com.carlos.model.Supplier;
import com.carlos.repository.ItemSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemSupplierServiceImple implements ItemSupplierService {
    @Autowired
    public ItemSupplierRepository itemSupplierRepository;

    @Override
    public List<Supplier> findByItemItemId(int item_id) {
        List<Supplier> suppliers = new ArrayList<>();
        List<ItemSupplier> itemSuppliers = itemSupplierRepository.findByItemItemId(item_id);

        for (ItemSupplier itemSupplier : itemSuppliers) {
            suppliers.add(itemSupplier.getSupplier());
        }

        return suppliers;
    }

    @Override
    public ItemSupplier save(ItemSupplier itemSupplier) {
        return itemSupplierRepository.save(itemSupplier);
    }
}
