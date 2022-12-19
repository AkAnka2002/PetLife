package com.example.petlife.controllers;

import com.example.petlife.models.Image;
import com.example.petlife.models.Note;
import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.repositories.UserRepository;
import com.example.petlife.services.NoteService;
import com.example.petlife.services.PetService;
import com.example.petlife.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.security.Principal;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class NoteController {
    private final UserRepository userRepository;
    private final NoteService noteService;
    private final PetService petService;
    private final UserService userService;

    @PostMapping("/pet/{id}/note")
    public String createNote(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file, Note note, Principal principal, Model model) throws IOException {
        noteService.saveNote(principal, note, file, id) ;
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("pet", petService.getPetById(id));
        return "redirect:/pet/{id}";
    }

    @GetMapping("/pet/{id}/note")
    public String noteAdd(@PathVariable("id") Long id, Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("pet", petService.getPetById(id));
        return "note";
    }

    @PostMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable Long id, Model model, Principal principal) {
        Note note = noteService.getNoteById(id);
        Pet pet = note.getPet();
        noteService.deleteNote(id);
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("pet", pet);
        model.addAttribute("image", pet.getImage());
        model.addAttribute("notes", pet.getNotes());
        return "pet-info";
    }
}
