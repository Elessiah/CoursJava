package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
