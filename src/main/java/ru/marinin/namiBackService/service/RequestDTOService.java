package ru.marinin.namiBackService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.marinin.namiBackService.mappers.RequestMapper;
import ru.marinin.namiBackService.model.RequestForConsumer;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.repository.RequestDTORepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestDTOService {

    private final RequestDTORepository requestDTORepository;

    public void saveNewRequest(RequestForConsumer RequestForConsumer) {
        requestDTORepository.save(RequestMapper.RFCtoRDTO(RequestForConsumer));
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
