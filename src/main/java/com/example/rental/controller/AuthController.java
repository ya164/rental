package com.example.rental.controller;

import com.example.rental.dto.AuthRequest;
import com.example.rental.dto.AuthResponse;
import com.example.rental.model.User;
import com.example.rental.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Реєстрація нового користувача
     */
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        try {
            String message = authService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    /**
     * Логін користувача та отримання JWT токена
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthRequest authRequest) {
        try {
            AuthResponse authResponse = authService.authenticateUser(authRequest);
            return ResponseEntity.ok(authResponse);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
    }
}
