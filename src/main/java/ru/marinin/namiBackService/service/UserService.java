package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.model.User;

import ru.marinin.namiBackService.model.enums.Role;
import ru.marinin.namiBackService.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email)!=null) {
            System.out.println("ALREADY EXIST");
            return false;
        } else {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.USER);
            System.out.println("Saving new user with email: " + email + ".");
            System.out.println(user);
            userRepository.save(user);
            return true;
        }
    }

    public List<User> getAllExperts() {
        return userRepository.findAll();
    }
}
