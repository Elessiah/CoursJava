package com.example.demospringboot.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevMessageService implements MessageService {
    @Override
    public String getMessage() {
        return ("Message envoyé depuis le dev !");
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getMessage());
    }
}
