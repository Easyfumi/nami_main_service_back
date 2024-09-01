package ru.marinin.namiBackService.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.Message;

@Component
class MyKafkaListener {
    @KafkaListener(topics = "test_topic", groupId = "myGroup")
    void listener(Message data) {
        System.out.println(data);
    }
}
