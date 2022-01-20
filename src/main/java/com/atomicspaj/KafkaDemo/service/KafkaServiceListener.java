package com.atomicspaj.KafkaDemo.service;

import com.atomicspaj.KafkaDemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaServiceListener {

    @KafkaListener(topics = "demoTopic", groupId = "demoGroup", containerFactory = "userKafkaListenerContainerFactory")
    public void listenGroupFoo(User user) {
        log.info("Received Message in group demoGroup: " + user.getFirstName());
    }
}
