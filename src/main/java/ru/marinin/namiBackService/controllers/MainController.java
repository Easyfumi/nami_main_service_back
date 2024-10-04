package ru.marinin.namiBackService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainController(Model model) {
        model.addAttribute("title", "Главная страница");
        return "main";
    }
    @GetMapping("/user")
    public String userController(Model model) {
        model.addAttribute("title", "User страница");
        return "user";
    }
    @GetMapping("/admin")
    public String adminController(Model model) {
        model.addAttribute("title", "Admin страница");
        return "admin";
    }
}
