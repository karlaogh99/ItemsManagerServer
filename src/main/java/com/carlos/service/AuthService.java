package com.carlos.service;

import com.carlos.config.AuthResponse;
import com.carlos.config.JwtService;
import com.carlos.config.LoginRequest;
import com.carlos.config.RegisterRequest;
import com.carlos.model.Role;
import com.carlos.model.User;
import com.carlos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private UserRepository userRepository;
    public AuthResponse login( LoginRequest request){
        return null;
    }
    public AuthResponse register( RegisterRequest request){
        User usuario = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .role(Role.USER)
                .build();
        userService.save(usuario);
        return AuthResponse.builder()
                .token(jwtService.getToken(usuario))
                .build();
    }
}
