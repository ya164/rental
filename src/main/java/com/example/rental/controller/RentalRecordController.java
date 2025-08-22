// src/main/java/com/example/rental/controller/RentalRecordController.java
package com.example.rental.controller;

import com.example.rental.dto.RentalRecordDto;
import com.example.rental.service.RentalRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rental-records")
public class RentalRecordController {

    @Autowired
    private RentalRecordService rentalRecordService;

    /**
     * Create a new rental record. Accessible by authenticated users.
     */
    @PostMapping
    public ResponseEntity<RentalRecordDto> createRentalRecord(@Valid @RequestBody RentalRecordDto rentalRecordDto) {
        RentalRecordDto createdRecord = rentalRecordService.createRentalRecord(rentalRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    /**
     * Get rental records of the currently authenticated user.
     */
    @GetMapping
    public ResponseEntity<List<RentalRecordDto>> getUserRentalRecords() {
        // Retrieve the authenticated user's ID
        Long userId = ((com.example.rental.service.CustomUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        List<RentalRecordDto> records = rentalRecordService.getUserRentalRecords(userId);
        return ResponseEntity.ok(records);
    }
}
