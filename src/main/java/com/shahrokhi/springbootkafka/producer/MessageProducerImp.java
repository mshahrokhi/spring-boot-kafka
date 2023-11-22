package com.shahrokhi.springbootkafka.producer;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerImp implements MessageProducer {

    private final Logger logger = LogManager.getLogger(MessageProducerImp.class);

    @Value("${kafka.topic.name.sendSms}")
    private String sendSmsTopic;

    @Value("${kafka.topic.name.sendEmail}")
    private String sendEmailTopic;

    private final KafkaTemplate<String, SendSmsRequest> sendSmsKafkaTemplate;
    private final KafkaTemplate<String, SendEmailRequest> sendEmailKafkaTemplate;

    @Autowired
    public MessageProducerImp(
            KafkaTemplate<String, SendSmsRequest> sendSmsKafkaTemplate,
            KafkaTemplate<String, SendEmailRequest> sendEmailKafkaTemplate) {
        this.sendSmsKafkaTemplate = sendSmsKafkaTemplate;
        this.sendEmailKafkaTemplate = sendEmailKafkaTemplate;
    }

    @Override
    public void sendSms(SendSmsRequest request) {
        sendSmsKafkaTemplate.send(sendSmsTopic, request);
        logger.info(String.format("Producer SendSmsRequest sent -> %s", request.toString()));
    }

    @Override
    public void sendEmail(SendEmailRequest request) {
        sendEmailKafkaTemplate.send(sendEmailTopic, request);
        logger.info(String.format("Producer SendEmailRequest sent -> %s", request.toString()));
    }
}
