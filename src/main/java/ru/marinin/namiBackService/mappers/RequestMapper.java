package ru.marinin.namiBackService.mappers;

import ru.marinin.namiBackService.model.Request;
import ru.marinin.namiBackService.model.RequestDTO;
import ru.marinin.namiBackService.model.RequestForConsumer;
import ru.marinin.namiBackService.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class RequestMapper {
    public static RequestDTO RFCtoRDTO(RequestForConsumer requestForConsumer) {
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setFactoryName(requestForConsumer.getFactoryName());
        requestDTO.setPersonData(requestForConsumer.getPersonData());
        requestDTO.setEmail(requestForConsumer.getEmail());
        requestDTO.setType(requestForConsumer.getType());
        requestDTO.setVehicleType(requestForConsumer.getVehicleType());
        requestDTO.setCategory(requestForConsumer.getCategory());
        requestDTO.setPathToFileRequest(requestForConsumer.getPathToFileRequest());
        requestDTO.setPathToFileOTO(requestForConsumer.getPathToFileOTO());
        requestDTO.setDescription(requestForConsumer.getDescription());

        LocalDateTime dateTime = requestForConsumer.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);

        requestDTO.setDateTime(formattedDateTime);

        return requestDTO;
    }

    public static Request RDTOtoR(RequestDTO requestDTO, User user) {
        Request request = new Request();
        request.setPersonData(requestDTO.getPersonData());
        request.setEmail(requestDTO.getEmail());
        request.setDescription(requestDTO.getDescription());
        request.setType(requestDTO.getType());
        request.setVehicleType(requestDTO.getVehicleType());
        request.setCategory(requestDTO.getCategory());
        request.setDateTime(requestDTO.getDateTime());
        request.setPathToFileRequest(requestDTO.getPathToFileRequest());
        request.setPathToFileOTO(requestDTO.getPathToFileOTO());
        request.setFactoryName(requestDTO.getFactoryName());
        request.setExpert(user);
        return request;
    }


    //TODO добавить проверку для Optional .ifPresent()
    public static Request RDTOtoR(Optional<RequestDTO> requestDTO, User user) {
        Request request = new Request();
        if (requestDTO.isPresent()) {
        request.setPersonData(requestDTO.get().getPersonData());
        request.setEmail(requestDTO.get().getEmail());
        request.setDescription(requestDTO.get().getDescription());
        request.setType(requestDTO.get().getType());
        request.setVehicleType(requestDTO.get().getVehicleType());
        request.setCategory(requestDTO.get().getCategory());
        request.setDateTime(requestDTO.get().getDateTime());
        request.setPathToFileRequest(requestDTO.get().getPathToFileRequest());
        request.setPathToFileOTO(requestDTO.get().getPathToFileOTO());
        request.setFactoryName(requestDTO.get().getFactoryName());
        request.setExpert(user);
        }
        return request;
    }
}