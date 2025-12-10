package fr.m1sdv.bestioles.model;

import jakarta.persistence.*;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String common_name;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String latin_name;

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", common_name='" + common_name + '\'' +
                ", latin_name='" + latin_name + '\'' +
                '}';
    }
}
