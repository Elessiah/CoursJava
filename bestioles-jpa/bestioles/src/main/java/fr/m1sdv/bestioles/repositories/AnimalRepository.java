package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findAllBySpecies(Species species);
    List<Animal> findAllByColorIn(List<String> colors);
}
