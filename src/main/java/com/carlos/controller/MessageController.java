package com.carlos.controller;

import com.carlos.model.Item;
import com.carlos.model.Supplier;
import com.carlos.service.ItemService;
import com.carlos.service.ItemSupplierService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000/" )
public class MessageController {
    @Autowired
    ItemService service;
    @Autowired
    private ItemSupplierService itemSupplierService;
    @GetMapping("/allItems")
    public List<Item> getAllItems(){
        try {
            List<Item> a = service.getAllItem();
            for (Item item : a) {
                item.getUser_id().setCreatedItems(null); // Evita recursión infinita
            }
            return a;
        }catch (Exception e){
            throw new RuntimeException("Error while fetching items", e);
        }
    }
    @GetMapping("/itemSuppliers/{item_id}")
    public ResponseEntity<List<Supplier>> getItemSuppliers(@PathVariable int item_id) {
        try {
            List<Supplier> suppliers = itemSupplierService.findByItemItemId(item_id);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/messages")

    public ResponseEntity<List<String>> messages(){
        return ResponseEntity.ok(Arrays.asList("first","second"));
    }
}
