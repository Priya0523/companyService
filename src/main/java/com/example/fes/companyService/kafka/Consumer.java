package com.example.fes.companyService.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    public static final String TOPIC_NAME = "estock";
    public static final String GROUP_ID = "mygroup";

    @KafkaListener(topics = "estock", groupId = "mygroup")
    public String consume(String message) {
        log.debug("Consumed message {}",message);
        log.debug("Message recieved -> {}",message);
        return  "Message recieved:"+message;
    }
}
