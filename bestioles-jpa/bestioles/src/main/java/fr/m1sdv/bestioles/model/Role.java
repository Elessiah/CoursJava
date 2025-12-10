package fr.m1sdv.bestioles.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private int id;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @ManyToMany(mappedBy="roles")
    private Set<Person> persons;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }
}
