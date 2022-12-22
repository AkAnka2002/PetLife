package com.example.petlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
//    private boolean isPreviewImage; //Флаг для "главной" фотографии
    @Lob
    private byte[] bytes; // массив байтов
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    // каскад - как повлияет удаление(действие) с сущностью фотографии на сущностью Pet
    // fetch - способ загрузки. Ленивая загрузка - животное сразу же не подключается, но по итогу получается полностью - быстрая работа кода, это не ленивый
    private Pet pet;
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private User user;
}
