//package com.example.petlife.models;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.springframework.format.annotation.DateTimeFormat;
//
//import java.time.LocalDateTime;
//import java.util.HashSet;
//
//@Entity
//@Table(name = "users")
//@Data
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "email", unique = true)
//    private String email;
//    @Column(name = "phone_number")
//    private String phoneNumber;
//    @Column(name = "name")
//    private String name;
//    @Column(name = "active")
//    private boolean active; //true - пользователь активен
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "image_id")
//    private Image avatar;
//    @Column(name = "password", length = 1000)
//    private String password;
//    @Column(name = "active")
//    private Set<Role> roles = new HashSet<>();
//    private LocalDateTime dateOfCreated;
//
//    @PrePersist
//    private void init(){
//        dateOfCreated = LocalDateTime.now();
//    }
//}
