// src/main/java/com/example/rental/dto/RentalRecordDto.java
package com.example.rental.dto;

import java.time.LocalDate;

public class RentalRecordDto {
    private Long id;
    private Long userId;
    private Long rentalObjectId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalCost;

    // Constructors
    public RentalRecordDto() {}

    public RentalRecordDto(Long id, Long userId, Long rentalObjectId, LocalDate startDate, LocalDate endDate, Double totalCost) {
        this.id = id;
        this.userId = userId;
        this.rentalObjectId = rentalObjectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRentalObjectId() {
        return rentalObjectId;
    }

    public void setRentalObjectId(Long rentalObjectId) {
        this.rentalObjectId = rentalObjectId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    // toString
    @Override
    public String toString() {
        return "RentalRecordDto{id=" + id +
                ", userId=" + userId +
                ", rentalObjectId=" + rentalObjectId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalCost=" + totalCost + '}';
    }
}
