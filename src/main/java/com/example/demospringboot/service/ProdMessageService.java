package com.example.demospringboot.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdMessageService implements MessageService {
    @Override
    public String getMessage() {
        return "Hello Prod!";
    }

    @PostConstruct
    public void init() {
        System.out.println(this.getMessage());
    }
}
