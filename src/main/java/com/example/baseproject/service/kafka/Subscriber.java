package com.example.baseproject.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Subscriber {

    @KafkaListener(topics = "test", groupId = "group_id")
    public void subs(String message){
        System.out.println("message = " + message);
    }
}
