package com.example.Kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {
    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;

    public void send(String message, int key){

        kafkaTemplate.send(topicName, key, message);
//        kafkaTemplate.send(topicName, message);

    }
}
