package com.veterinary.hospital_api.service;

import com.veterinary.hospital_api.entity.Owner;
import com.veterinary.hospital_api.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    // CREATE - Guardar un dueño
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    // READ - Obtener todos los dueños
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    // READ - Obtener dueño por ID
    public Optional<Owner> getOwnerById(Long id) {
        return ownerRepository.findById(id);
    }

    // UPDATE - Actualizar dueño
    public Owner updateOwner(Long id, Owner ownerDetails) {
        Owner owner = ownerRepository.findById(id).orElseThrow();
        owner.setName(ownerDetails.getName());
        owner.setPhone(ownerDetails.getPhone());
        owner.setEmail(ownerDetails.getEmail());
        return ownerRepository.save(owner);
    }

    // DELETE - Eliminar dueño
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}