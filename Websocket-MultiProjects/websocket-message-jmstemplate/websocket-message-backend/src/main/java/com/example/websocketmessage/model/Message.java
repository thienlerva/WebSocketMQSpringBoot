package com.example.websocketmessage.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Message {

    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
