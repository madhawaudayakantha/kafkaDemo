package com.madh.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PhoneProducer {

    public static final String topic = "phone-topic";

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public PhoneProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToTopic(String message) {
        System.out.println("Publishing to phone-topic" + topic);
         kafkaTemplate.send(topic, message);
    }
}
