package com.shahrokhi.springbootkafka.model;

import lombok.Data;

@Data
public class MessageResponse {
    private String resultCode;
    private String resultDesc;

    public void setSuccess() {
        this.resultCode = "200";
        this.resultDesc = "Success";
    }
}
