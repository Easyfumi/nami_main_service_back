package ru.marinin.namiBackService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.marinin.namiBackService.model.enums.Role;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

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
    private String pathToFileRequest;
    private String pathToFileOTO;
    private String description;
    private String dateTime;
//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> expert = new HashSet<>();

    public RequestDTO(Request request) {
        this.factoryName = request.getFactoryName();
        this.personData = request.getPersonData();
        this.email = request.getEmail();
        this.type = request.getType();
        this.pathToFileRequest = request.getPathToFileRequest();
        this.pathToFileOTO = request.getPathToFileOTO();
        this.description = request.getDescription();
        LocalDateTime dateTime = request.getLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = dateTime.format(formatter);
        System.out.println(formattedDateTime);
        this.dateTime = formattedDateTime;
    }
}
