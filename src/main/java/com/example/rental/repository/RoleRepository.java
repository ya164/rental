// src/main/java/com/example/rental/repository/RoleRepository.java
package com.example.rental.repository;

import com.example.rental.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
