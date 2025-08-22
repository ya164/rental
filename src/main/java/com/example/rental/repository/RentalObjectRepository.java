// src/main/java/com/example/rental/repository/RentalObjectRepository.java
package com.example.rental.repository;

import com.example.rental.model.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectRepository extends JpaRepository<RentalObject, Long> {
    // Additional query methods if needed
}
