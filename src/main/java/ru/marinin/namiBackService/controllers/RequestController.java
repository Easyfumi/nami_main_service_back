package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.model.User;
import ru.marinin.namiBackService.service.RequestDTOService;
import ru.marinin.namiBackService.service.RequestService;
import ru.marinin.namiBackService.service.UserService;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestDTOService requestDTOService;
    private final RequestService requestService;
    private final UserService userService;

    @GetMapping("/admin/newRequests")
    public String newRequestsController(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("newRequests", requestDTOService.getAllRequests());
        model.addAttribute("allExperts",userService.getAllExperts());
        return "newRequests";
    }
    @PostMapping("/admin/newRequests")
    public String selectExpert(@RequestParam long id, @RequestParam long user_id) {
        Optional<RequestDTO> requestDTO = requestDTOService.findById(id);
        System.out.println(requestDTO);

        User user = userService.getById(user_id);
        System.out.println(user);

        if (requestDTO.isEmpty()) return "redirect:/admin/newRequests";

        Request request = new Request();
        request.setPersonData(requestDTO.get().getPersonData());
        request.setEmail(requestDTO.get().getPersonData());
        request.setDescription(requestDTO.get().getDescription());
        request.setType(requestDTO.get().getType());
        request.setPathToFileRequest(requestDTO.get().getPathToFileRequest());
        request.setPathToFileOTO(requestDTO.get().getPathToFileOTO());
        request.setFactoryName(requestDTO.get().getFactoryName());
        request.setExpert(user);

        System.out.println(request);

        if (requestService.saveRequest(request)) {
            System.out.println("По заявке на тип " + requestDTO.get().getType() + " назначен эксперт "
                    + user.getFirstName() + " " + user.getLastName() + ".");
            requestDTOService.deleteById(requestDTO.get().getId());
            return "redirect:/admin/newRequests";
        } else {
            return "redirect:/admin/newRequests";
        }


    }

}
