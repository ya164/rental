// src/main/java/com/example/rental/service/RentalRecordService.java
package com.example.rental.service;

import com.example.rental.dto.RentalRecordDto;
import com.example.rental.model.RentalObject;
import com.example.rental.model.RentalRecord;
import com.example.rental.model.User;
import com.example.rental.repository.RentalObjectRepository;
import com.example.rental.repository.RentalRecordRepository;
import com.example.rental.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalRecordService {

    @Autowired
    private RentalRecordRepository rentalRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentalObjectRepository rentalObjectRepository;

    @Transactional
    public RentalRecordDto createRentalRecord(RentalRecordDto rentalRecordDto) {
        User user = userRepository.findById(rentalRecordDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        RentalObject rentalObject = rentalObjectRepository.findById(rentalRecordDto.getRentalObjectId())
                .orElseThrow(() -> new RuntimeException("Rental Object not found"));

        if(rentalObject.getStatus() != RentalObject.Status.AVAILABLE) {
            throw new RuntimeException("Rental Object is not available");
        }

        long days = ChronoUnit.DAYS.between(rentalRecordDto.getStartDate(), rentalRecordDto.getEndDate());
        if(days <= 0) {
            throw new RuntimeException("Invalid rental period");
        }
        double totalCost = days * rentalObject.getPricePerDay();

        RentalRecord rentalRecord = new RentalRecord();
        rentalRecord.setUser(user);
        rentalRecord.setRentalObject(rentalObject);
        rentalRecord.setStartDate(rentalRecordDto.getStartDate());
        rentalRecord.setEndDate(rentalRecordDto.getEndDate());
        rentalRecord.setTotalCost(totalCost);

        // Update rental object status
        rentalObject.setStatus(RentalObject.Status.OCCUPIED);
        rentalObjectRepository.save(rentalObject);

        RentalRecord savedRecord = rentalRecordRepository.save(rentalRecord);
        return mapToDto(savedRecord);
    }

    @Transactional
    public List<RentalRecordDto> getUserRentalRecords(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return rentalRecordRepository.findByUser(user)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private RentalRecordDto mapToDto(RentalRecord rentalRecord) {
        return new RentalRecordDto(
                rentalRecord.getId(),
                rentalRecord.getUser().getId(),
                rentalRecord.getRentalObject().getId(),
                rentalRecord.getStartDate(),
                rentalRecord.getEndDate(),
                rentalRecord.getTotalCost()
        );
    }
}
