package com.example.baseproject.service.kafka;

import com.example.baseproject.constant.BaseConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(Object request){
        kafkaTemplate.send(BaseConstant.TOPIC, request);
    }
}
