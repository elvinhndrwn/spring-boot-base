package com.example.baseproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @JmsListener(destination = "netsurfingzone-queue")
    public void consumeMessage(String message) {
        log.info("Message received from activemq queue---"+message);
    }
}
