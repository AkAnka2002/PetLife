package com.example.petlife.services;

import com.example.petlife.models.Pet;
import com.example.petlife.repositories.PetRepository;
import com.example.petlife.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> listPets(String type) {
        List<Pet> pets = petRepository.findAll();
        if (type != null) return petRepository.findByType(type);
        return petRepository.findAll(); }

    public  void savePet(Pet pet) {
        log.info("Saving new {}", pet);
        petRepository.save(pet);
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
}
