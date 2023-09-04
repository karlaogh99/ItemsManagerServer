package com.carlos.controller;

import com.carlos.model.User;
import com.carlos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/api/users")
    public List<User> getAllUser(){
        return service.getAllUser();
    }

    @DeleteMapping("/api/usersDele/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int user_id) {
        try {
            service.deleteUser(user_id);
            return ResponseEntity.noContent().build(); // Respuesta 204 No Content
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Respuesta 500 Internal Server Error
        }
    }


    @GetMapping("/test23")
    public String test23(){
        return "test foundddd";
    }
}
