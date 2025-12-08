package com.example.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BavardService {
    private String nom;

    public BavardService(String nom) {
        this.nom = nom;
    }

    public void setNom(String newName) {
        this.nom = newName;
    }

    public String getNom() {
        return (this.nom);
    }

    public void parler() {
        System.out.println("");
    }
}
