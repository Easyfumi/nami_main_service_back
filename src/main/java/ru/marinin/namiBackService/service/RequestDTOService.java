package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.model.KafkaRequest;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.repository.RequestDTORepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestDTOService {

    private final RequestDTORepository requestDTORepository;

//    public void saveNewRequest(String factoryName, String personData, String email,
//    String type, String pathToFileRequest, String pathToFileOTO, String description, LocalDateTime localDateTime) {
//        Request request = new Request(factoryName, personData, email, type, pathToFileRequest, pathToFileOTO, description, localDateTime);
//        Request request1 = requestRepository.save(request);
//    }

    public void saveNewRequest(KafkaRequest KafkaRequest) {
        RequestDTO requestDTO = new RequestDTO(KafkaRequest);
        RequestDTO requestDTOFromDB = requestDTORepository.save(requestDTO);
        System.out.println(KafkaRequest);
    }

    public List<RequestDTO> getAllRequests() {
        return requestDTORepository.findAll();
    }

    public Optional<RequestDTO> findById(long id) {
        return requestDTORepository.findById(id);
    }

    public void deleteById(long id) {
        requestDTORepository.deleteById(id);
    }
}
