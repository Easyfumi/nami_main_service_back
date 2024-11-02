package ru.marinin.namiBackService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private String vehicleType;
    private String category;
    private String pathToFileRequest;
    private String pathToFileOTO;
    private String description;
    private String dateTime;
}
