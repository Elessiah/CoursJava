package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    List<Species> findAllByLatinNameIgnoreCase(String latinName);

}
