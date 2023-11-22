package com.shahrokhi.springbootkafka.controller;

import com.shahrokhi.springbootkafka.model.SendEmailRequest;
import com.shahrokhi.springbootkafka.model.SendSmsRequest;
import com.shahrokhi.springbootkafka.model.MessageResponse;
import com.shahrokhi.springbootkafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/sendSms")
    public MessageResponse sendSms(@RequestBody SendSmsRequest request) {
        messageService.sendSms(request);
        MessageResponse response = new MessageResponse();
        response.setSuccess();
        return response;
    }

    @PostMapping("/sendEmail")
    public MessageResponse sendEmail(@RequestBody SendEmailRequest request) {
        messageService.sendEmail(request);
        MessageResponse response = new MessageResponse();
        response.setSuccess();
        return response;
    }
}
