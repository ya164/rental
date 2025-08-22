// src/main/java/com/example/rental/model/RentalObject.java
package com.example.rental.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rental_objects")
public class RentalObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double pricePerDay;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Constructors
    public RentalObject() {}

    public RentalObject(Long id, String name, String description, Double pricePerDay, Status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

    // Enum for status
    public enum Status {
        AVAILABLE,
        OCCUPIED,
        UNDER_MAINTENANCE
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // toString
    @Override
    public String toString() {
        return "RentalObject{id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", status=" + status + '}';
    }
}
