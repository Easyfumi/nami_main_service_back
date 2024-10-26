package ru.marinin.namiBackService.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.marinin.namiBackService.model.enums.Role;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private String pathToFileRequest;
    private String pathToFileOTO;
    private String description;
    private LocalDateTime localDateTime;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User expert;
}
