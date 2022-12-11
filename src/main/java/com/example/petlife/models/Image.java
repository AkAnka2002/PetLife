package com.example.petlife.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName; //чтобы передавать фотографию
    @Column(name = "size")
    private Long size; //Размер файла
    @Column(name = "contentType")
    private String contentType; //Расширение файла
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage; //Флаг для "главной" фотографии
    @Lob
    private byte[] bytes; // массив байтов
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) //отношение много фотографий к одному животному,
    // каскад - как повлияет удаление(действие) с сущностью фотографии на сущностью Pet
    // fetch - способ загрузки. Ленивая загрузка - животное сразу же не подключается, но по итогу получается полностью - быстрая работа кода, это не ленивый
    private Pet pet;

}
