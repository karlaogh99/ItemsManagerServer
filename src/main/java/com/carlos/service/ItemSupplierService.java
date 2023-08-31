package com.carlos.service;

import com.carlos.model.ItemSupplier;
import com.carlos.model.Supplier;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public interface ItemSupplierService {
    List<Supplier> findByItemItemId(int item_id);
}
