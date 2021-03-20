package com.example.websocketmessage.controller;

import com.example.websocketmessage.model.Message;
import com.example.websocketmessage.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

    @Autowired
    GreetingService greetingService;

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Message greeting() {
        return greetingService.getMessage();
    }
}
