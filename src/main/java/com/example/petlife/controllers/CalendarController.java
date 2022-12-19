package com.example.petlife.controllers;

import com.example.petlife.models.CalendarNote;
import com.example.petlife.models.Note;
import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.repositories.UserRepository;
import com.example.petlife.services.CalendarService;
import com.example.petlife.services.NoteService;
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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class CalendarController {
    private final UserRepository userRepository;
    private final CalendarService calendarService;
    private final UserService userService;

    @PostMapping("/user/{id}/calendar")
    public String createNote(@PathVariable("id") Long id, CalendarNote note, Principal principal, Model model) throws IOException {
        calendarService.saveCalendare(principal, note, id);
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("notes", user.getCalendarNotes());
        return "calendar";
    }

    @GetMapping("/user/{id}/calendar")
    public String noteCalAdd(@PathVariable("id") Long id, @RequestParam("date") LocalDate date, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        Set<CalendarNote> notes = new HashSet<>();
        for (CalendarNote element : user.getCalendarNotes()) {
            if (element.getDate().equals(date)) {
                notes.add(element);
            }
        }
        model.addAttribute("notes", notes);
        model.addAttribute("date", date);
        return "calendar-notes";
    }

    @PostMapping("/calnote/{id}/delete/{id1}")
    public String deleteCalNote(@PathVariable Long id, @PathVariable Long id1,  Model model, Principal principal) {
        calendarService.deleteCalNote(id1);
        User user = userRepository.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("notes", user.getCalendarNotes());
        return "calendar";
    }

//    @PostMapping("/calendarnote/delete/{id}")
//    public String deleteCalNote(@PathVariable Long id, Model model, Principal principal) {
//        CalendarNote note = calendarService.getCalNoteById(id);
//        User user = note.getUser();
//        calendarService.deleteCalNote(id);
//        model.addAttribute("user", user);
//        model.addAttribute("notes", user.getCalendarNotes());
//        return "calendar-notes";
//    }
}