package com.example.petlife.services;

import com.example.petlife.models.Image;
import com.example.petlife.models.Note;
import com.example.petlife.models.Pet;
import com.example.petlife.repositories.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final PetService petService;

    public void saveNote(Principal principal, Note note, MultipartFile file, Long id) throws IOException {
        System.out.println("PetServiceSave");
        note.setPet(petService.getPetById(id));
        Image image;
        if (file.getSize() != 0) {
            image = petService.toImageEntity(file);
            note.setImage(image);
        }
//        else {
//            MultipartFile file1 = new MockMultipartFile("img_1.png", new FileInputStream(new File("src/main/resources/static/images/img_1.png")));
//            image = petService.toImageEntity(file1);
//            image.setContentType("image/jpeg");
//            image.setOriginalFileName("img_1.png");
//            note.setImage(image);
//        }
        log.info("Saving new Note. Title: {}", note.getTitle());
        noteRepository.save(note);
    }
}
