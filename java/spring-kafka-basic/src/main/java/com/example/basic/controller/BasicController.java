package com.example.basic.controller;

import com.example.basic.model.BasicMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BasicController {

    private final KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send/message/{value}")
    public void sendMessage(@PathVariable String value) {
        this.template.send("basic-topic", new BasicMessage(value));
    }
}
