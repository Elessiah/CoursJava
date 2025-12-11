package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Person;

import java.util.List;

public interface PersonRepositoryCustom {
    int deleteWithoutAnimals();

    List<Person> generatePerson(int number);
}
