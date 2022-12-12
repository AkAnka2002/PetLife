package com.example.petlife.services;

import com.example.petlife.models.Image;
import com.example.petlife.models.Pet;
import com.example.petlife.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return petRepository.findAll();
    }

    public void savePet(Pet pet, MultipartFile file) throws IOException {
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            image.setPreviewImage(true);
            pet.addImageToPet(image);
        }
        log.info("Saving new Pet. Name: {}; Type: {}", pet.getName(), pet.getType());
        Pet petFromDb = petRepository.save(pet);
        petFromDb.setPreviewImageId(petFromDb.getImages().get(0).getId());
        petRepository.save(pet);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
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
