package com.shahrokhi.springbootkafka.consumer;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private final Logger logger = LogManager.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "${kafka.topic.name.sendSms}")
    public void sendSmsConsumer(String request) {
        logger.info(String.format("Consumer SendSmsRequest received -> %s", request));
    }

    @KafkaListener(topics = "${kafka.topic.name.sendEmail}")
    public void sendEmailConsumer(String request) {
        logger.info(String.format("Consumer SendEmailRequest received -> %s", request));
    }
}
