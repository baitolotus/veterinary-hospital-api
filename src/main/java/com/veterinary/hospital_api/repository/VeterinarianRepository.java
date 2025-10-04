package com.veterinary.hospital_api.repository;

import com.veterinary.hospital_api.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
}
