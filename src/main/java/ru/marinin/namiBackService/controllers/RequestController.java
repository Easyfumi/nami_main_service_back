package ru.marinin.namiBackService.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.marinin.namiBackService.mappers.RequestMapper;
import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.model.RequestForProducer;
import ru.marinin.namiBackService.model.User;
import ru.marinin.namiBackService.service.MyKafkaSender;
import ru.marinin.namiBackService.service.RequestDTOService;
import ru.marinin.namiBackService.service.RequestService;
import ru.marinin.namiBackService.service.UserService;

import java.util.Optional;

@CrossOrigin("*")
@Controller
@RequiredArgsConstructor
public class RequestController {

    private final RequestDTOService requestDTOService;
    private final RequestService requestService;
    private final UserService userService;

    @Autowired
    MyKafkaSender kafkaSender;

    @GetMapping("/admin/newRequests")
    public String newRequestsController(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("newRequests", requestDTOService.getAllRequests());
        model.addAttribute("allExperts", userService.getAllExperts());
        return "newRequests";
    }

    @PostMapping("/admin/newRequests")
    public String selectExpert(@RequestParam long id, @RequestParam long user_id) {

        Optional<RequestDTO> requestDTO = requestDTOService.findById(id);
        User user = userService.getById(user_id);

        if (requestDTO.isEmpty()) return "redirect:/admin/newRequests";

        Request request = RequestMapper.RDTOtoR(requestDTO, user);

        if (requestService.saveRequest(request)) {
            System.out.println("По заявке на тип " + requestDTO.get().getType() + " назначен эксперт "
                    + user.getFirstName() + " " + user.getLastName() + ".");

            String expertInfo = user.getLastName() + " " + user.getFirstName() + " "
                    + user.getDaddyName() + ", email: " + user.getEmail();

            RequestForProducer requestForProducer = RequestMapper.RtoRFP(request, expertInfo);

            kafkaSender.sendMessage(requestForProducer, "request_topic_2");

            requestDTOService.deleteById(requestDTO.get().getId());

            return "redirect:/admin/newRequests";
        } else {
            return "redirect:/admin/newRequests";
        }
    }

    @GetMapping("/request/{id}")
    public String requestDetails(@PathVariable(value = "id") long id, Model model) {

        model.addAttribute("request", requestService.getById(id));
        return "request_details";
    }

}
