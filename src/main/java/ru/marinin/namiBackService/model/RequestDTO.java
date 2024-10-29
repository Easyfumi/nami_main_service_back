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
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> expert = new HashSet<>();

    public RequestDTO(KafkaRequest KafkaRequest) {
        this.factoryName = KafkaRequest.getFactoryName();
        this.personData = KafkaRequest.getPersonData();
        this.email = KafkaRequest.getEmail();
        this.type = KafkaRequest.getType();
        this.vehicleType = KafkaRequest.getVehicleType();
        this.category = KafkaRequest.getCategory();
        this.pathToFileRequest = KafkaRequest.getPathToFileRequest();
        this.pathToFileOTO = KafkaRequest.getPathToFileOTO();
        this.description = KafkaRequest.getDescription();
        LocalDateTime dateTime = KafkaRequest.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(formattedDateTime);
        this.dateTime = formattedDateTime;
    }
}
