package com.madh.kafkaDemo.service;

import com.madh.kafkaDemo.repository.RepoUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = {"my-topic"}, groupId = "mygroup")
    public void consumeFromTopic(String message) {
        RepoUtils.laptops.add(message);
        System.out.println("Consumed message" +  message);
        System.out.println("laptops" +    RepoUtils.laptops.get(0) + RepoUtils.laptops.size());
    }
}
