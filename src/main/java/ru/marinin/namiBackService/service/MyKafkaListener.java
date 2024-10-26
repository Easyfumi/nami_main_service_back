package ru.marinin.namiBackService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.model.Request;

@Component
class MyKafkaListener {

    @Autowired
    RequestDTOService requestDTOService;

    @KafkaListener(topics = "request_topic", groupId = "myGroup")
    void listener(Request data) {
        requestDTOService.saveNewRequest(data);
    }
}
