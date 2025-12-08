package com.example.demospringboot.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService {
    @Override
    public String getMessage() {
        return ("Message par SMS.");
    }
}
