package com.carlos.controller;

import com.carlos.model.Supplier;
import com.carlos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000/" )
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @GetMapping("/allSupplier")
    public List<Supplier> getAllSupplier(){
        return supplierService.getAllSupplier();
    }
}
