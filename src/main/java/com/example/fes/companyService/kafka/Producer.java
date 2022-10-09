package com.example.fes.companyService.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    public static final String TOPIC_NAME = "estock";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.debug("Publishing to topic {} ", TOPIC_NAME);
        log.debug(String.format("Message sent -> %s", message));
        kafkaTemplate.send(TOPIC_NAME, message);

    }
}
