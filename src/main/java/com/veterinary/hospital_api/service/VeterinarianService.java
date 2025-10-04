package com.veterinary.hospital_api.service;

import com.veterinary.hospital_api.entity.Veterinarian;
import com.veterinary.hospital_api.repository.VeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public Veterinarian saveVeterinarian(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianRepository.findAll();
    }

    public Optional<Veterinarian> getVeterinarianById(Long id) {
        return veterinarianRepository.findById(id);
    }

    public Veterinarian updateVeterinarian(Long id, Veterinarian veterinarianDetails) {
        Veterinarian veterinarian = veterinarianRepository.findById(id).orElseThrow();
        veterinarian.setName(veterinarianDetails.getName());
        veterinarian.setSpecialty(veterinarianDetails.getSpecialty());
        veterinarian.setLicenseNumber(veterinarianDetails.getLicenseNumber());
        return veterinarianRepository.save(veterinarian);
    }

    public void deleteVeterinarian(Long id) {
        veterinarianRepository.deleteById(id);
    }
}