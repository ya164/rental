// src/main/java/com/example/rental/repository/RentalRecordRepository.java
package com.example.rental.repository;

import com.example.rental.model.RentalRecord;
import com.example.rental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRecordRepository extends JpaRepository<RentalRecord, Long> {
    List<RentalRecord> findByUser(User user);
}
