package com.madh.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LaptopProducer {

    public static final String topic = "laptop-topic";

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public LaptopProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToTopic(String message) {
        System.out.println("Publishing to laptop-topic" + topic);
         kafkaTemplate.send(topic, message);
    }
}
