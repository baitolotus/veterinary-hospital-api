package com.veterinary.hospital_api.repository;

import com.veterinary.hospital_api.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    //Spring Boot crea automáticamente:
    //findAll(), findById(), save(), deleteById(), etc!
}