package com.madh.kafkaDemo.controller;

import com.madh.kafkaDemo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = {
                "http://localhost:3000"
        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("madh-app")
public class MessageController {

    @Autowired
    Producer producer;

    @PostMapping("/post")
    public void sendMessage(@RequestParam("msg") String msg) {
        producer.publishToTopic(msg);
    }

}
