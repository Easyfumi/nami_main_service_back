package ru.marinin.namiBackService.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.namiBackService.model.RequestForProducer;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, RequestForProducer> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, RequestForProducer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RequestForProducer RequestForProducer, String topicName) {
        kafkaTemplate.send(topicName, RequestForProducer);
    }
}
