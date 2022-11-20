package com.example.petlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private Long id;
    private String name;
    private String type;
    private int age;
    private String description;
//    private String author;
}
