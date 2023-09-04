package com.carlos.controller;

import com.carlos.model.Supplier;
import com.carlos.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/cheapestItem")
    public ResponseEntity<List<Object[]>> getCheapestItemsPerSupplier() {
        List<Object[]> result = supplierService.findCheapestItemsPerSupplier();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/assiociatedItems")
    public ResponseEntity<List<Object[]>> getAssiociatedItems() {
        List<Object[]> result = supplierService.suppliers_Associated_with_Items();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
