// src/main/java/com/example/rental/dto/RentalObjectDto.java
package com.example.rental.dto;

import com.example.rental.model.RentalObject;

public class RentalObjectDto {
    private Long id;
    private String name;
    private String description;
    private Double pricePerDay;
    private RentalObject.Status status;

    // Constructors
    public RentalObjectDto() {}

    public RentalObjectDto(Long id, String name, String description, Double pricePerDay, RentalObject.Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public RentalObject.Status getStatus() {
        return status;
    }

    public void setStatus(RentalObject.Status status) {
        this.status = status;
    }

    // toString
    @Override
    public String toString() {
        return "RentalObjectDto{id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", status=" + status + '}';
    }
}
