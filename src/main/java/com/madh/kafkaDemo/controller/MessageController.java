package com.madh.kafkaDemo.controller;

import com.madh.kafkaDemo.repository.RepoUtils;
import com.madh.kafkaDemo.service.LaptopProducer;
import com.madh.kafkaDemo.service.PhoneProducer;
import com.madh.kafkaDemo.service.WatchProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    LaptopProducer laptopProducer;

    @Autowired
    PhoneProducer phoneProducer;

    @Autowired
    WatchProducer watchProducer;

    @PostMapping("/laptops")
    public void sendLaptopMessage(@RequestParam("name") String msg) {
        laptopProducer.publishToTopic(msg);
    }

    @GetMapping("/laptops")
    public ResponseEntity<List<String>> getAllLaptops() {
        return new ResponseEntity<>(RepoUtils.laptops, HttpStatus.OK);
    }

    @PostMapping("/phones")
    public void sendPhoneMessage(@RequestParam("name") String msg) {
        phoneProducer.publishToTopic(msg);
    }

    @GetMapping("/phones")
    public ResponseEntity<List<String>> getAllPhones() {
        return new ResponseEntity<>(RepoUtils.phones, HttpStatus.OK);
    }

    @PostMapping("/watches")
    public void sendWatchMessage(@RequestParam("name") String msg) {
        watchProducer.publishToTopic(msg);
    }

    @GetMapping("/watches")
    public ResponseEntity<List<String>> getAllWatches() {
        return new ResponseEntity<>(RepoUtils.watches, HttpStatus.OK);
    }
}
