package com.carlos.controller;

import com.carlos.model.User;
import com.carlos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/test")
    public List<User> getAllUser(){
        return service.getAllUser();
    }
    @GetMapping("/test23")
    public String test23(){
        return "test foundddd";
    }
}
