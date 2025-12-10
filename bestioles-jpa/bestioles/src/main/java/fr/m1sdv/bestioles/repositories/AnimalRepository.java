package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
