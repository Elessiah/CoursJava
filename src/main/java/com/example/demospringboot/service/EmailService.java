package com.example.demospringboot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return ("Message envoyé par email.");
    }
}
