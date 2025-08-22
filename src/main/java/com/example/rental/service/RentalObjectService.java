// src/main/java/com/example/rental/service/RentalObjectService.java
package com.example.rental.service;

import com.example.rental.dto.RentalObjectDto;
import com.example.rental.model.RentalObject;
import com.example.rental.repository.RentalObjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalObjectService {

    @Autowired
    private RentalObjectRepository rentalObjectRepository;

    @Transactional
    public List<RentalObjectDto> getAllRentalObjects() {
        return rentalObjectRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public RentalObjectDto getRentalObjectById(Long id) {
        RentalObject rentalObject = rentalObjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental Object not found"));
        return mapToDto(rentalObject);
    }

    @Transactional
    public RentalObjectDto createRentalObject(RentalObjectDto rentalObjectDto) {
        RentalObject rentalObject = new RentalObject();
        rentalObject.setName(rentalObjectDto.getName());
        rentalObject.setDescription(rentalObjectDto.getDescription());
        rentalObject.setPricePerDay(rentalObjectDto.getPricePerDay());
        rentalObject.setStatus(rentalObjectDto.getStatus());

        RentalObject savedObject = rentalObjectRepository.save(rentalObject);
        return mapToDto(savedObject);
    }

    @Transactional
    public RentalObjectDto updateRentalObject(Long id, RentalObjectDto rentalObjectDto) {
        RentalObject rentalObject = rentalObjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental Object not found"));

        rentalObject.setName(rentalObjectDto.getName());
        rentalObject.setDescription(rentalObjectDto.getDescription());
        rentalObject.setPricePerDay(rentalObjectDto.getPricePerDay());
        rentalObject.setStatus(rentalObjectDto.getStatus());

        RentalObject updatedObject = rentalObjectRepository.save(rentalObject);
        return mapToDto(updatedObject);
    }

    @Transactional
    public void deleteRentalObject(Long id) {
        RentalObject rentalObject = rentalObjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental Object not found"));
        rentalObjectRepository.delete(rentalObject);
    }

    private RentalObjectDto mapToDto(RentalObject rentalObject) {
        return new RentalObjectDto(
                rentalObject.getId(),
                rentalObject.getName(),
                rentalObject.getDescription(),
                rentalObject.getPricePerDay(),
                rentalObject.getStatus()
        );
    }
}
