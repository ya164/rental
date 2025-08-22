// src/main/java/com/example/rental/service/FinancialSummaryService.java
package com.example.rental.service;

import com.example.rental.model.RentalRecord;
import com.example.rental.model.User;
import com.example.rental.repository.RentalRecordRepository;
import com.example.rental.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class FinancialSummaryService {

    @Autowired
    private RentalRecordRepository rentalRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Double getTotalRentalsForUser(Long userId, String period) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<RentalRecord> records = rentalRecordRepository.findByUser(user);

        LocalDate now = LocalDate.now();
        LocalDate startDate;

        switch (period.toLowerCase()) {
            case "month":
                startDate = now.minusMonths(1);
                break;
            case "year":
                startDate = now.minusYears(1);
                break;
            default:
                throw new RuntimeException("Invalid period. Use 'month' or 'year'.");
        }

        return records.stream()
                .filter(record -> !record.getStartDate().isBefore(startDate) && !record.getStartDate().isAfter(now))
                .mapToDouble(RentalRecord::getTotalCost)
                .sum();
    }
}
