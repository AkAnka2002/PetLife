package com.example.petlife.repositories;

import com.example.petlife.models.CalendarNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarNoteRepository extends JpaRepository<CalendarNote, Long> {
}
