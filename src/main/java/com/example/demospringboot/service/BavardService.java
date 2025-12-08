package com.example.demospringboot.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BavardService {
    @Value("${spring.application.name:project}")
    private String nom;

    public String parler() {
        return(nom + " " + this.getClass().getSimpleName());
    }

    @PostConstruct
    private void PostConstruct() {
        System.out.println("Bavard service is started");
    }

    public void setNom(String newName) {
        this.nom = newName;
    }

    public String getNom() {
        return (this.nom);
    }
}
