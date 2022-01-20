package com.atomicspaj.KafkaDemo.controller;

import com.atomicspaj.KafkaDemo.model.User;
import com.atomicspaj.KafkaDemo.service.KafkaServicePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    KafkaServicePublisher kafkaServicePublisher;

    @PostMapping("/api/users")
    public ResponseEntity addUserViaKafka(@RequestBody User user)
    {
        log.info("Adding user via Kafka invoked");
        kafkaServicePublisher.sendMessage(user);
        return new ResponseEntity<>(user.getFirstName(), HttpStatus.ACCEPTED);
    }
}
