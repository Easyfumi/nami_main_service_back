package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.marinin.namiBackService.service.UserService;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/admin")
    public String adminController(Model model) {
        model.addAttribute("title", "Admin страница");
        return "admin";
    }
    @GetMapping("/admin/experts")
    public String expertsController(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("experts", userService.getAllExperts());
        return "experts";
    }

}
