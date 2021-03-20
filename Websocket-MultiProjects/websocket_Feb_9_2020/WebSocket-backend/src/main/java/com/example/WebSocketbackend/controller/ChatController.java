package com.example.WebSocketbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ChatController {

    @Autowired
    SimpMessagingTemplate template;

    @MessageMapping("/send/message")
    public void onReceiveMessage(String message) {
        System.out.println(message);
        this.template.convertAndSend("/chat", new SimpleDateFormat("HH:mm:ss")
                .format(new Date()) + "- " + message);
    }
}
