package com.carlos.controller;


import com.carlos.config.AuthResponse;
import com.carlos.config.JwtService;
import com.carlos.model.Role;
import com.carlos.model.User;
import com.carlos.service.AuthService;
import com.carlos.config.LoginRequest;
import com.carlos.config.RegisterRequest;
import com.carlos.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final UserService userService;
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @PostMapping (value = "admin")
    public ResponseEntity<String>  isAdmin (@RequestBody Map<String, String> request){
        String username = request.get("username");
        User user = userService.findByUsername(username).get();

        if (user != null && user.getRole() == Role.ADMIN.ADMIN) {
            return ResponseEntity.ok("admin");
        }

        return ResponseEntity.ok("user");
    }
}
