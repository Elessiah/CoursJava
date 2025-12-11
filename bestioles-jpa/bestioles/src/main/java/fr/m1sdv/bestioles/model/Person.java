package fr.m1sdv.bestioles.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Entity
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstname;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastname;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String login;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String mdp;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    @ColumnDefault("1")
    private Byte active = 1;

    @ManyToMany
    @JoinTable(
            name="person_role",
            joinColumns = @JoinColumn(name="person_id",
                                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
            )
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(
            name="person_animals",
            joinColumns = @JoinColumn(name="person_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="animals_id", referencedColumnName = "id")
    )
    private Set<Animal> animals;

    @Override
    public String toString() {
        return ("{id: " + id + "; firstname:  " + firstname + "; lastname: " + lastname + "; age: " + age + "; login: " + login + "; mdp: " + mdp + "; active: " + active + "}");
    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public void setActive(boolean active) {
        this.active = (byte) (active ? 1 : 0);
    }

    public boolean isActive() {
        return active == 1;
    }
}
