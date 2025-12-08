package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    private MessageService messageService;

    @Autowired
    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }
}
