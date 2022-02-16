package com.example.baseproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@Slf4j
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void send(Object o){
        log.info("Send message {}", o);
        jmsTemplate.convertAndSend(queue, o);
    }
}
