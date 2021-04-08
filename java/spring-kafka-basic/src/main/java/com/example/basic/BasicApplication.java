package com.example.basic;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Log4j2
@SpringBootApplication
public class BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @KafkaListener(id = "basicGroup", topics = "basic-topic")
    public void receiveMessage(String input) {
        log.info("Received from basic-topic: " + input);
    }
}
