package com.shahrokhi.springbootkafka.service;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;
import com.shahrokhi.springbootkafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageProducer messageProducer;

    @Autowired
    public MessageService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendSms(SendSmsRequest request) {
        messageProducer.sendSms(request);
    }

    public void sendEmail(SendEmailRequest request) {
        messageProducer.sendEmail(request);
    }
}
