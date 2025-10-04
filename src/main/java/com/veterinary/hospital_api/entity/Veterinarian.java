package com.veterinary.hospital_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "veterinarians")

public class Veterinarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private String licenseNumber;

    public Veterinarian() {}

    public Veterinarian(String name, String specialty, String licenseNumber) {
        this.name = name;
        this.specialty = specialty;
        this.licenseNumber = licenseNumber;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
}
