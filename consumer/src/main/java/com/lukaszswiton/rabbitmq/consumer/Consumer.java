package com.lukaszswiton.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
class Consumer {

    void receiveMessage(String message) {
        log.debug("Received <{}>", message);
    }
}
