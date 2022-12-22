package com.example.petlife.services;

import com.example.petlife.models.CalendarNote;
import com.example.petlife.repositories.CalendarNoteRepository;
import com.example.petlife.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
@Service
@Slf4j
@RequiredArgsConstructor
public class CalendarService {
    private final CalendarNoteRepository calendarNoteRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public void saveCalendare(Principal principal, CalendarNote note, Long id) throws IOException {
        note.setUser(userRepository.findByEmail(principal.getName()));
        log.info("Saving new Note. Date: {}", note.getDate());
        calendarNoteRepository.save(note);
    }

    public CalendarNote getCalNoteById(Long id) {
        return calendarNoteRepository.findById(id).orElse(null);
    }

    public void deleteCalNote(Long id) {
        calendarNoteRepository.deleteById(id);
    }
}
