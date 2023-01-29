package com.lukaszswiton.rabbitmq.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
class ProducerController {

    static final String TOPIC_EXCHANGE_NAME = "sample-topic";

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send-message")
    ResponseEntity<String> sendMessage(@RequestBody String message) {
        log.debug("Received message <{}>", message);
        log.debug("Sending message to RabbitMQ");
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "foo.bar.baz", message);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}
