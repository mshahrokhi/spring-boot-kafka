package com.shahrokhi.springbootkafka.producer;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;

public interface MessageProducer {
    void sendSms(SendSmsRequest request);
    void sendEmail(SendEmailRequest request);
}
