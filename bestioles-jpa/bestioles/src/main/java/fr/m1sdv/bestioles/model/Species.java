package fr.m1sdv.bestioles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="common_name", columnDefinition = "varchar(50)", nullable = false)
    private String commonName;

    @Column(name= "latin_name", columnDefinition = "varchar(200)", nullable = false)
    private String latinName;

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", common_name='" + commonName + '\'' +
                ", latin_name='" + latinName + '\'' +
                '}';
    }
}
