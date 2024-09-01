package ru.marinin.namiBackService.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.model.Request;

@Component
class MyKafkaListener {
    @KafkaListener(topics = "request_topic", groupId = "myGroup")
    void listener(Request data) {
        System.out.println(data);
    }
}
