package com.shahrokhi.springbootkafka.model;

import lombok.Data;

@Data
public class SendSmsRequest {
    private String sender;
    private String message;
    private String receiver;
}
