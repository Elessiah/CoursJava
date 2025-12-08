package com.example.demospringboot;

import com.example.demospringboot.service.BavardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;

@SpringBootApplication
@RestController
public class DemoSpringbootApplication {

    private BavardService bavardService;

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringbootApplication.class, args);
    }

    @GetMapping("hello")
    public String hello(@RequestParam String name) {
        return "<b>Hello</b> " + name;
    }

    @GetMapping("blahblah")
    public String blahblah() {
        return this.bavardService.parler();
    }

    @Autowired
    public DemoSpringbootApplication(BavardService bavardService) {
        this.bavardService = bavardService;
    }
}
