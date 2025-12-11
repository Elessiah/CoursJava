package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);
    List<Species> findAllByLatinNameIgnoreCase(String latinName);
    @Query("from Species ORDER BY commonName ASC ")
    List<Species> findAllOrderByCommonNameAsc();
    @Query("from Species WHERE commonName LIKE :firstname")
    List<Species> findAllByCommonName(@Param("firstname") String firstname);
}
