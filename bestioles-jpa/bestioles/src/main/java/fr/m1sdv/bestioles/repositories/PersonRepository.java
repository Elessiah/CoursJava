package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Person;
import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByFirstnameOrLastname(String firstname, String lastname);
    List<Person> findAllByAgeGreaterThanEqual(int age);
}
