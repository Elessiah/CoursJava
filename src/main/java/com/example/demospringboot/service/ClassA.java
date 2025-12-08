package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ClassA {
    private ClassB classB;
    @Autowired
    public ClassA(ClassB classB) {
        this.classB = classB;
    }
}
