package com.example.petlife.controllers;

import com.example.petlife.models.Image;
import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.repositories.PetRepository;
import com.example.petlife.repositories.UserRepository;
import com.example.petlife.services.PetService;
import com.example.petlife.services.UserService;
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
    private final UserService userService;
    private final UserRepository userRepository;
    private final PetRepository petRepository;

    @GetMapping("/")
    public String pets(@RequestParam(name = "type", required = false) String type, Principal principal, Model model) {
        model.addAttribute("pets", petService.listPets(type)); // передаем список всех товаров
        model.addAttribute("user", petService.getUserByPrincipal(principal));
        return "pets";
    }

    @GetMapping("/pet/{id}")
    public String petInfo(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        Pet pet = petService.getPetById(id);
        model.addAttribute("pet", pet);
        model.addAttribute("image", pet.getImage());
        model.addAttribute("notes", pet.getNotes());
        return "pet-info";
    }

    @PostMapping("/pet/{id}/create")
    public String createPet(@RequestParam("file") MultipartFile file, @PathVariable Long id, Pet pet, Principal principal, Model model) throws IOException {
        User user = userRepository.findByEmail(principal.getName());
        petService.savePet(user, pet, file) ;
        System.out.println("CREATEPET");
        return "redirect:/pet/{id}/mypet";
    }

    @PostMapping("/pet/delete/{id}")
    public String deletePet(@PathVariable Long id, Model model, Principal principal) {
        petService.deletePet(id);
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("pets", user.getPets());
        return "my-pets";
    }

    @GetMapping("/pet/add")
    public String petAdd(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "pet-add";
    }

    @GetMapping("/pet/{pet}/update")
    public String petUpdateButton(@PathVariable("pet") Pet pet, Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        if (!user.getPets().contains(pet)) {
            return "hello";
        }
        model.addAttribute("user", user);
        model.addAttribute("pet", pet);
        model.addAttribute("image", pet.getImage());
        return "pet-update";
    }

    @PostMapping("/pet/{id}/update")
    public String updatePet(@PathVariable Long id, @RequestParam("file") MultipartFile file, Model model, String gender,
                             String name, String type, String breed, Integer age, String castration, String description) throws IOException {
        Pet pet = petService.getPetById(id);
//        .orElseThrow()
        System.out.println("Update");
        if (name.length() != 0) pet.setName(name);
        if (type.length() != 0) pet.setType(type);
        if (breed.length() != 0) pet.setBreed(breed);
        if (gender.length() != 0) pet.setGender(gender);
        if (age != null) pet.setAge(age);
        if (castration.length() != 0) pet.setCastration(castration);
        if (description.length() != 0) pet.setDescription(description);
        Image image;
        if (file.getSize() != 0) {
            image = userService.toImageEntity(file);
            pet.setImage(image);
        }
        petRepository.save(pet);
        return "redirect:/pet/{id}";
    }

    @GetMapping("/calendar")
    public String getCalendar (Model model, Principal principal) {
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        return "calendar";
    }

    @GetMapping("/pet/{id}/mypet")
    public String userInfoPets(@PathVariable("id") Long id, Model model, Principal principal) {
        User user1 = userRepository.findByEmail(principal.getName());
        if (user1.getId() != id) {
            return "hello";
        }
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("pets", user.getPets());
        return "my-pets";
    }
}
