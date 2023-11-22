package com.shahrokhi.springbootkafka.model;

import lombok.Data;

import java.io.File;
import java.util.List;

@Data
public class SendEmailRequest {
    private String sender;
    private String message;
    private List<String> receivers;
    private List<File> attach;
}
