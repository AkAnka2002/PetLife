package com.example.petlife.controllers;

import com.example.petlife.models.Pet;
import com.example.petlife.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/")
    public String pets(Model model) {
        model.addAttribute("pets", petService.listPets()); // передаем список всех товаров
        return "pets";
    }

    @GetMapping("/pet/{id}")
    public String petInfo(@PathVariable Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id));
        return "pet-info";
    }

    @PostMapping("/pet/create")
    public String createPet(Pet pet){
        petService.savePet(pet);
        return "redirect:/";
    }

    @PostMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/";
    }
}
