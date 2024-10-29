package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.marinin.namiBackService.model.User;
import ru.marinin.namiBackService.repository.RequestRepository;
import ru.marinin.namiBackService.service.RequestService;
import ru.marinin.namiBackService.service.UserService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final RequestService requestService;
    private final UserService userService;

    @GetMapping("/")
    public String mainController(Model model) {
        model.addAttribute("title", "Мои заявки");
        model.addAttribute("myRequests", userService.getAllWithCurrentExpert());
        return "main";
    }
}
