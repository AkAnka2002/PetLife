package com.example.petlife.controllers;

import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/")
    public String pets(@RequestParam(name = "type", required = false) String type, Principal principal, Model model) {
        model.addAttribute("pets", petService.listPets(type)); // передаем список всех товаров
        model.addAttribute("user", petService.getUserByPrincipal(principal));
        return "pets";
    }

    @GetMapping("/pet/{id}")
    public String petInfo(@PathVariable Long id, Model model) {
        Pet pet = petService.getPetById(id);
//        System.out.println(pet.getId().getClass());
//        System.out.println(pet.getId().toString());
        model.addAttribute("pet", pet);
        model.addAttribute("images", pet.getImages());
        return "pet-info";
    }

    @PostMapping("/pet/create")
    public String createPet(@RequestParam("file") MultipartFile file, Pet pet, Principal principal) throws IOException {
        System.out.println("PetController");
        petService.savePet(principal, pet, file) ;
        return "redirect:/";
    }

    @PostMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable Long id) {
        petService.deletePet(id);
        return "redirect:/";
    }
}
