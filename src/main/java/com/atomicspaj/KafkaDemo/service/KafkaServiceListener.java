package com.atomicspaj.KafkaDemo.service;

import com.atomicspaj.KafkaDemo.model.User;
import com.atomicspaj.KafkaDemo.model.UserEntityAvro;
import com.atomicspaj.KafkaDemo.util.AvroMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaServiceListener {

    @Autowired
    AvroMapper avroMapper;

    @KafkaListener(topics = "demoTopic", groupId = "demoGroup", containerFactory = "userKafkaListenerContainerFactory")
    public void listenGroupFoo(User user) {
        log.info("Received Message in group demoGroup: " + user.getFirstName());
        log.info("Converting the received data to AVro schema");
        UserEntityAvro userEntityAvro = new UserEntityAvro();
        userEntityAvro.setFirstName(user.getFirstName());
        userEntityAvro.setLastName(user.getLastName());
        log.info("Avro schema data is " + userEntityAvro.toString());
        byte[] serilaizedData = avroMapper.serilalizeUserEnityAvro(userEntityAvro);
        log.info("Serilazied Data is :" + serilaizedData);


    }
}
