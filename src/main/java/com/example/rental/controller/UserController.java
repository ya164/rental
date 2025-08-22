package com.example.rental.controller;

import com.example.rental.dto.UserProfileDto;
import com.example.rental.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Отримати профіль поточного користувача
     */
    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile() {
        UserProfileDto profile = userService.getCurrentUserProfile();
        return ResponseEntity.ok(profile);
    }

    /**
     * Оновити профіль поточного користувача
     */
    @PutMapping("/profile")
    public ResponseEntity<UserProfileDto> updateUserProfile(@Valid @RequestBody UserProfileDto userProfileDto) {
        UserProfileDto updatedProfile = userService.updateUserProfile(userProfileDto);
        return ResponseEntity.ok(updatedProfile);
    }
}
