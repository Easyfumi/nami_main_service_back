package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.marinin.namiBackService.service.UserService;
import java.io.IOException;

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


    @GetMapping("/admin/experts/{id}")
    public String expertDetails(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("expert", userService.getById(id));
        return "expert";
    }

    @GetMapping("/admin/experts/{id}/getRoleUser")
    public String expertRoleUserUpdate(@PathVariable(value = "id") long id, Model model) throws IOException {
        userService.updateRoleToUser(id);
        model.addAttribute("expert", userService.getById(id));
        return "redirect:/admin/experts/{id}";
    }

    @GetMapping("/admin/experts/{id}/getRoleAdmin")
    public String expertRoleAdminUpdate(@PathVariable(value = "id") long id, Model model) throws IOException {
        userService.updateRoleToAdmin(id);
        model.addAttribute("expert", userService.getById(id));
        return "redirect:/admin/experts/{id}";
    }

}
