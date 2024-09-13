package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.repository.RequestRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

//    public void saveNewRequest(String factoryName, String personData, String email,
//    String type, String pathToFileRequest, String pathToFileOTO, String description, LocalDateTime localDateTime) {
//        Request request = new Request(factoryName, personData, email, type, pathToFileRequest, pathToFileOTO, description, localDateTime);
//        Request request1 = requestRepository.save(request);
//    }

    public void saveNewRequest(Request request) {
        RequestDTO requestDTO = new RequestDTO(request);
        RequestDTO requestDTOFromDB = requestRepository.save(requestDTO);
        System.out.println(request);
    }

    public List<RequestDTO> getAllRequests() {
        return requestRepository.findAll();
    }
}
