package com.example.petlife.services;

import com.example.petlife.models.Image;
import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.repositories.PetRepository;
import com.example.petlife.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;

import java.io.*;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public List<Pet> listPets(String type) {
        List<Pet> pets = petRepository.findAll();
        if (type != null) return petRepository.findByType(type);
        return petRepository.findAll();
    }

    public void savePet(User user, Pet pet, MultipartFile file) throws IOException {
        System.out.println("PetServiceSave");
        pet.setUser(user);
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            pet.setImage(image);
        } else {
            MultipartFile file1 = new MockMultipartFile("img_1.png", new FileInputStream(new File("src/main/resources/static/images/img_1.png")));
            image = toImageEntity(file1);
            image.setContentType("image/jpeg");
            image.setOriginalFileName("img_1.png");
            pet.setImage(image);
        }
        log.info("Saving new Pet. Name: {}; Type: {}", pet.getName(), pet.getType());
        petRepository.save(pet);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).orElse(null);
    }
}
