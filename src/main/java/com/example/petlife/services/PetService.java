package com.example.petlife.services;

import com.example.petlife.models.Pet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private List<Pet> pets = new ArrayList<>();
    private long ID = 0;
    {
        pets.add(new Pet(++ID, "Bob", "cat", 5, "Simple description"));
        pets.add(new Pet(++ID, "Ruby", "fish", 2, "Simple description"));
    }

    public List<Pet> listPets() { return pets; }

    public  void savePet(Pet pet) {
        pet.setId(++ID);
        pets.add(pet);
    }

    public void deletePet(Long id) {
        pets.removeIf(pet -> pet.getId().equals(id));
    }

    public Pet getPetById(Long id) {
        for (Pet pet : pets) {
            if (pet.getId().equals(id)) return pet;
        }
        return null;
    }
}
