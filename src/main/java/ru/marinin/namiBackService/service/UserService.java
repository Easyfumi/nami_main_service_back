package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.model.User;

import ru.marinin.namiBackService.model.enums.Role;
import ru.marinin.namiBackService.repository.UserRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RequestService requestService;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        String email = user.getEmail();
        if (userRepository.findByEmail(email)!=null) {
            System.out.println("ALREADY EXIST");
            return false;
        } else {
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println("Saving new user with email: " + email + ".");
            System.out.println(user);
            userRepository.save(user);
            return true;
        }
    }

    public List<User> getAllExperts() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.getReferenceById(id);
    }

    public void updateRoleToUser(long id) {
        User user = userRepository.getReferenceById(id);
        user.getRoles().clear();
        user.getRoles().add(Role.USER);
        userRepository.save(user);
    }

    public void updateRoleToAdmin(long id) {
        User user = userRepository.getReferenceById(id);
        user.getRoles().clear();
        user.getRoles().add(Role.ADMIN);
        userRepository.save(user);
    }

    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<Request> getAllWithCurrentExpert(){
        String curName = this.getCurrentUser();
        long curId = this.findByEmail(curName).getId();
        return requestService.getAllRequestsWithExpertId(curId);
    }
}
