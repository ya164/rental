// src/main/java/com/example/rental/model/RentalRecord.java
package com.example.rental.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rental_records")
public class RentalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "rental_object_id", nullable = false)
    private RentalObject rentalObject;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double totalCost;

    // Constructors
    public RentalRecord() {}

    public RentalRecord(Long id, User user, RentalObject rentalObject, LocalDate startDate, LocalDate endDate, Double totalCost) {
        this.id = id;
        this.user = user;
        this.rentalObject = rentalObject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RentalObject getRentalObject() {
        return rentalObject;
    }

    public void setRentalObject(RentalObject rentalObject) {
        this.rentalObject = rentalObject;
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
        return "RentalRecord{id=" + id +
                ", user=" + user +
                ", rentalObject=" + rentalObject +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalCost=" + totalCost + '}';
    }
}
