package com.madh.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WatchProducer {

    public static final String topic = "watch-topic";

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public WatchProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishToTopic(String message) {
        System.out.println("Publishing to watch-topic" + topic);
         kafkaTemplate.send(topic, message);
    }
}
