package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Integer> {
}
