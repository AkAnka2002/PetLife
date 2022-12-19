package com.example.petlife.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "calendarNotes")
public class CalendarNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private User user;

    public CalendarNote(Long id, LocalDate date, String text, User user) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.user = user;
    }

    public CalendarNote() {
    }

}


