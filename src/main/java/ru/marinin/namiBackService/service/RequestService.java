package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.repository.RequestRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestService {

    private final RequestRepository requestRepository;

    public boolean saveRequest(Request request) {
        Request savedRequest = requestRepository.save(request);
        return savedRequest.getId() != 0;
    }

    public List<Request> getAllRequestsWithExpertId(long id) {
        return requestRepository.findAllByUser_id(id);
    }

    //TODO переделать в Optional<Request>
    public Request getById(long id) {
        return requestRepository.getById(id);
    }
}
