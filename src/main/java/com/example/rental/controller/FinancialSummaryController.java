// src/main/java/com/example/rental/controller/FinancialSummaryController.java
package com.example.rental.controller;

import com.example.rental.service.FinancialSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/financial-summary")
public class FinancialSummaryController {

    @Autowired
    private FinancialSummaryService financialSummaryService;

    /**
     * Get financial summary for the currently authenticated user.
     * @param period The period for summary (e.g., "month", "year")
     */
    @GetMapping
    public ResponseEntity<?> getFinancialSummary(@RequestParam String period) {
        // Retrieve the authenticated user's ID
        Long userId = ((com.example.rental.service.CustomUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        Double total = financialSummaryService.getTotalRentalsForUser(userId, period);
        return ResponseEntity.ok("Total rentals for " + period + ": " + total);
    }
}
