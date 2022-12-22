package com.example.petlife.controllers;

import com.example.petlife.models.Image;
import com.example.petlife.models.User;
import com.example.petlife.repositories.UserRepository;
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

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Principal principal, Model model) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) throws IOException {
        if (!userService.createUser(user, null, null)) {
            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model, Principal principal) {
        User user1 = userRepository.findByEmail(principal.getName());
        if (user1.getId() != user.getId() && !user1.isAdmin()) {
            return "hello";
        }
        System.out.println(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("pets", user.getPets());
        model.addAttribute("image", user.getAvatar());
        return "user-info";
    }

    @GetMapping("/user/{user}/update")
    public String userUpdateButton(@PathVariable("user") User user, Model model, Principal principal) {
        User user1 = userRepository.findByEmail(principal.getName());
        if (user1.getId() != user.getId() && !user1.isAdmin()) {
            return "hello";
        }
        model.addAttribute("user", user);
        model.addAttribute("image", user.getAvatar());
        return "user-update";
    }

    @PostMapping("/user/{id}/update")
    public String updateUser(@PathVariable Long id, @RequestParam("file") MultipartFile file, Model model, String gender,
                             String name, String phoneNumber, String email) throws IOException {
        User user = userService.getUserById(id);
//        .orElseThrow()
        if (name.length() != 0) user.setName(name);
        if (phoneNumber.length() != 0) user.setPhoneNumber(phoneNumber);
        if (gender.length() != 0) user.setGender(gender);
        Image image;
        if (file.getSize() != 0) {
            image = userService.toImageEntity(file);
            user.setAvatar(image);
        }
        userRepository.save(user);
        return "redirect:/user/{id}";
    }
}
