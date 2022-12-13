package com.example.petlife.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "age")
    private int age;
    @Column(name = "description", columnDefinition = "text")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pet")
    // все эти свойства принадлежат тому же самому pet, который написан в модели Pet. Создастся еще одно поле с id животного
    // Типа каскада All - при сохранении животного, включающего фотографии, сохранятся будут не только он, но и связанные с ним сущности
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    private LocalDateTime dateOfCreated; // дата создания

    public Pet(Long id, String name, String type, int age, String description, List<Image> images, Long previewImageId, LocalDateTime dateOfCreated) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.description = description;
        this.images = images;
        this.previewImageId = previewImageId;
        this.dateOfCreated = dateOfCreated;
    }

    public Pet() {
    }

    @PrePersist //метод инициализации, инвесряи управления внетренней зависимостью
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    public void addImageToPet(Image image) {
        image.setPet(this);
        images.add(image);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Pet;
    }
}
