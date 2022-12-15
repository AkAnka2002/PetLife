package com.example.petlife.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;
    private LocalDateTime dateOfCreated; // дата создания

    public Note(Long id, String title, String text, LocalDateTime dateOfCreated) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.dateOfCreated = dateOfCreated;
        this.image = image;
    }

    public Note() {
    }

    @PrePersist //метод инициализации, инвесряи управления внетренней зависимостью
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
}

