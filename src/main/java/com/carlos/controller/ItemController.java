package com.carlos.controller;

import com.carlos.model.*;
import com.carlos.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins ="http://localhost:3000/" )
public class ItemController {
    @Autowired
    ItemService service;
    @Autowired
    UserService userService;
    @Autowired
    SupplierService supplierService;
    @Autowired
    PriceReductionService priceReductionService;
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
    @PutMapping("/updateitems/{item_id}")
    public ResponseEntity<?> updateItems(@PathVariable int item_id,@RequestBody Item updatedItem ) {
            Item existingItem = service.findById(item_id).get();
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPrice(updatedItem.getPrice());

            Item updatedItemsave = service.save(existingItem);

            return ResponseEntity.ok(updatedItemsave);

    }
    @PostMapping("/desactivateItem/{item_id}")
    public ResponseEntity<?> desactivateItem(@PathVariable int item_id, @RequestBody String string){
        Item existingItem = service.findById(item_id).get();
        System.out.println(string + " " + item_id);
        String comenItem = existingItem.getDescription() + " /* reason for deactivation */: " + string ;
        existingItem.setState(StateEnum.Inactivo);
        existingItem.setDescription(comenItem);
        Item subido = service.save(existingItem);
        return ResponseEntity.ok(subido);
    }
    @GetMapping("/getPriceReductions/{item_id}")
    public List<PriceReduction> getPriceReduction(@PathVariable int item_id){
        return priceReductionService.findByItem_id(item_id);
    }
    @PostMapping("/insertPriceReduction/{item_id}")
    public ResponseEntity<?> createNewPriceReduction(@PathVariable int item_id, @RequestBody PriceReduction priceReduction){
        Item it = service.findById(item_id).get();
        System.out.println(priceReduction.getStartDate());
        PriceReduction finalPrice = priceReductionService.save(priceReduction);
        return ResponseEntity.ok(finalPrice);

    }

    @PostMapping("/creates")
    public ResponseEntity<?> createNewItem(@RequestBody Item item) {
        try {
            if (item.getDescription() == null || item.getState() == null) {
                return ResponseEntity.badRequest().body("Missing required fields");
            }
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Optional<User> userAGuardar = userService.findByUsername(username);

            item.setUser_id(userAGuardar.get());
            // Guarda el nuevo item en la base de datos
            StateEnum stateEnum = StateEnum.Activo;
            item.setState(stateEnum);
            item.setCreation_date(new Date());
            Item newItem = service.save(item);

            return ResponseEntity.ok(newItem);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating item");
        }
    }

    @PostMapping("/associateSupplier/{item_id}/{supplier_id}")
    public ItemSupplier assignSupplier(@PathVariable int item_id, @PathVariable int supplier_id){
        Item item = service.findById(item_id).get();
        Supplier supplier = supplierService.findById(supplier_id).get();
        ItemSupplier itemSupplier = new ItemSupplier();
        itemSupplier.setItem(item);
        itemSupplier.setSupplier(supplier);
        ItemSupplier newISup = itemSupplierService.save(itemSupplier);
        return newISup;
    }
    @GetMapping("/messages")

    public ResponseEntity<List<String>> messages(){
        return ResponseEntity.ok(Arrays.asList("first","second"));
    }
}
