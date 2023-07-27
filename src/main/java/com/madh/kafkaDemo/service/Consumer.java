package com.madh.kafkaDemo.service;

import com.madh.kafkaDemo.repository.RepoUtils;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @KafkaListener(topics = {"laptop-topic"}, groupId = "laptopgroup")
    public void consumeFromLaptopTopic(String message) {
        RepoUtils.laptops.add(message);
        System.out.println("Consumed laptop message" +  message);
        System.out.println("laptops" +    RepoUtils.laptops.get(0) + RepoUtils.laptops.size());
    }

    @KafkaListener(topics = {"phone-topic"}, groupId = "phonegroup")
    public void consumeFromPhoneTopic(String message) {
        RepoUtils.phones.add(message);
        System.out.println("Consumed phone message" +  message);
        System.out.println("phones" +    RepoUtils.phones.get(0) + RepoUtils.phones.size());
    }

    @KafkaListener(topics = {"watch-topic"}, groupId = "watchgroup")
    public void consumeFromWatchTopic(String message) {
        RepoUtils.watches.add(message);
        System.out.println("Consumed watch message" +  message);
        System.out.println("watches" +    RepoUtils.watches.get(0) + RepoUtils.watches.size());
    }
}
