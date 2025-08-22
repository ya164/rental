// src/main/java/com/example/rental/controller/RentalObjectController.java
package com.example.rental.controller;

import com.example.rental.dto.RentalObjectDto;
import com.example.rental.service.RentalObjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rental-objects")
public class RentalObjectController {

    @Autowired
    private RentalObjectService rentalObjectService;

    /**
     * Get all rental objects.
     */
    @GetMapping
    public ResponseEntity<List<RentalObjectDto>> getAllRentalObjects() {
        List<RentalObjectDto> objects = rentalObjectService.getAllRentalObjects();
        return ResponseEntity.ok(objects);
    }

    /**
     * Get a rental object by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RentalObjectDto> getRentalObjectById(@PathVariable Long id) {
        RentalObjectDto rentalObject = rentalObjectService.getRentalObjectById(id);
        return ResponseEntity.ok(rentalObject);
    }

    /**
     * Create a new rental object. Only accessible by users with ADMIN role.
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RentalObjectDto> createRentalObject(@Valid @RequestBody RentalObjectDto rentalObjectDto) {
        RentalObjectDto createdObject = rentalObjectService.createRentalObject(rentalObjectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdObject);
    }

    /**
     * Update an existing rental object by ID. Only accessible by users with ADMIN role.
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RentalObjectDto> updateRentalObject(@PathVariable Long id,
                                                              @Valid @RequestBody RentalObjectDto rentalObjectDto) {
        RentalObjectDto updatedObject = rentalObjectService.updateRentalObject(id, rentalObjectDto);
        return ResponseEntity.ok(updatedObject);
    }

    /**
     * Delete a rental object by ID. Only accessible by users with ADMIN role.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteRentalObject(@PathVariable Long id) {
        rentalObjectService.deleteRentalObject(id);
        return ResponseEntity.ok("Rental Object deleted successfully");
    }
}
