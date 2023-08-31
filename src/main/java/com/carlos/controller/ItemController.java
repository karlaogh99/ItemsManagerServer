package com.carlos.controller;

import com.carlos.model.Item;
import com.carlos.model.StateEnum;
import com.carlos.model.Supplier;
import com.carlos.model.User;
import com.carlos.service.ItemService;
import com.carlos.service.ItemSupplierService;
import com.carlos.service.UserService;
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
    @PostMapping("/creates")
    public ResponseEntity<?> createNewItem(@RequestBody Item item) {
        try {
            // Verifica si los campos obligatorios están presentes en el objeto Item
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

    @GetMapping("/messages")

    public ResponseEntity<List<String>> messages(){
        return ResponseEntity.ok(Arrays.asList("first","second"));
    }
}
