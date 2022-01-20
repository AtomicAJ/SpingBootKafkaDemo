package com.atomicspaj.KafkaDemo.service;

import com.atomicspaj.KafkaDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaServicePublisher {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        log.info("Publishing message:"+user.toString());
        kafkaTemplate.send("demoTopic", user);
        log.info("Published successfully");
    }
}
