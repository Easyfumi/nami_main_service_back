package ru.marinin.namiBackService.model;

import lombok.Data;
import java.time.LocalDateTime;
@Data
public class RequestForConsumer {
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private String vehicleType;
    private String category;
    private String pathToFileRequest;
    private String pathToFileOTO;
    private String description;
    private LocalDateTime localDateTime;
    @Override
    public String toString() {
        return "Request{" +
                "factoryName='" + factoryName + '\'' +
                ", personData='" + personData + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                ", pathToFileRequest='" + pathToFileRequest + '\'' +
                ", pathToFileOTO='" + pathToFileOTO + '\'' +
                ", description='" + description + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
}