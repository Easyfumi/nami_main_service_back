package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.marinin.namiBackService.model.User;
import ru.marinin.namiBackService.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    //TODO добавить проверку на уже существующего юзера
    @PostMapping("/registration")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
