package ru.marinin.namiBackService.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.model.KafkaSendRequest;
import ru.marinin.zaklRequest.model.KafkaRequest;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, KafkaSendRequest> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, KafkaSendRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(KafkaSendRequest KafkaSendRequest, String topicName) {
        kafkaTemplate.send(topicName, KafkaSendRequest);
    }
}
