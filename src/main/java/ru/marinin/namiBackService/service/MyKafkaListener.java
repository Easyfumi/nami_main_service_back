package ru.marinin.namiBackService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.model.RequestForConsumer;

@Component
class MyKafkaListener {

    @Autowired
    RequestDTOService requestDTOService;

    @KafkaListener(topics = "request_topic_1", groupId = "myGroup")
    void listener(RequestForConsumer data) {
        requestDTOService.saveNewRequest(data);
    }
}
