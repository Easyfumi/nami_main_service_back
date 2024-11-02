package ru.marinin.namiBackService.model;

import lombok.Data;

@Data
public class RequestForProducer {
    private long id;
    private long internalNumber;
    private String factoryName;
    private String personData;
    private String email;
    private String type;
    private String vehicleType;
    private String category;
    private String description;
    private String dateTime;
    private String expertInfo;
}
