package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marinin.namiBackService.service.RequestService;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @GetMapping("/admin/newRequests")
    public String newRequestsController(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("newRequests", requestService.getAllRequests());
        return "newRequests";
    }
}
