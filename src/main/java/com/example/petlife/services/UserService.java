// базовая логика регистрации
package com.example.petlife.services;

import com.example.petlife.models.Image;
import com.example.petlife.models.Pet;
import com.example.petlife.models.User;
import com.example.petlife.models.enams.Role;
import com.example.petlife.repositories.PetRepository;
import com.example.petlife.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PetService petService;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser (User user, MultipartFile file, String gender) throws IOException {
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // шифрование пароля
        user.getRoles().add(Role.ROLE_ADMIN);
        Image image;
        if (file != null) {
            image = toImageEntity(file);
        } else {
            MultipartFile file1 = new MockMultipartFile("img.png", new FileInputStream(new File("src/main/resources/static/images/img.png")));
            image = petService.toImageEntity(file1);
            image.setContentType("image/jpeg");
            image.setOriginalFileName("img.png");
        }
        user.setAvatar(image);
        if (gender != null) {
            user.setGender(gender);
        } else {
            user.setGender("Пол не указан");
        }
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()){
                user.setActive(false);
                log.info("Ban user with id = {}; email = {}", user.getId(), user.getEmail());
            } else {
                log.info("Unban user with id = {}; email = {}", user.getId(), user.getEmail());
                user.setActive(true);
            }
        }
        userRepository.save(user);

    }

    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet()); // преобразуем все роли в строковый вид
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public Object getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
