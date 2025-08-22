// src/main/java/com/example/rental/service/UserService.java
package com.example.rental.service;

import com.example.rental.dto.UserProfileDto;
import com.example.rental.model.User;
import com.example.rental.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserProfileDto getCurrentUserProfile() {
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserProfileDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone()
        );
    }

    @Transactional
    public UserProfileDto updateUserProfile(UserProfileDto userProfileDto) {
        CustomUserDetails userDetails =
                (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userRepository.findById(userDetails.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmail(userProfileDto.getEmail());
        user.setPhone(userProfileDto.getPhone());

        userRepository.save(user);

        return new UserProfileDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone()
        );
    }
}
