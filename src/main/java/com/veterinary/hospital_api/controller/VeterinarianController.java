package com.veterinary.hospital_api.controller;

import com.veterinary.hospital_api.entity.Veterinarian;
import com.veterinary.hospital_api.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veterinarians")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;

    @PostMapping
    public Veterinarian createVeterinarian(@RequestBody Veterinarian veterinarian) {
        return veterinarianService.saveVeterinarian(veterinarian);
    }

    @GetMapping
    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianService.getAllVeterinarians();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Long id) {
        Optional<Veterinarian> veterinarian = veterinarianService.getVeterinarianById(id);
        return veterinarian.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinarian> updateVeterinarian(@PathVariable Long id, @RequestBody Veterinarian veterinarianDetails) {
        try {
            Veterinarian updatedVeterinarian = veterinarianService.updateVeterinarian(id, veterinarianDetails);
            return ResponseEntity.ok(updatedVeterinarian);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVeterinarian(@PathVariable Long id) {
        try {
            veterinarianService.deleteVeterinarian(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}