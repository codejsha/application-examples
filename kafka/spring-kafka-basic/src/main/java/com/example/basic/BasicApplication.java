package com.example.basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class BasicApplication {

    private static Logger logger = LogManager.getLogger(BasicApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BasicApplication.class, args);
    }

    @KafkaListener(id = "basicGroup", topics = "basic-topic")
    public void receiveMessage(String input) {
        logger.info("Received from basic-topic: " + input);
    }
}
