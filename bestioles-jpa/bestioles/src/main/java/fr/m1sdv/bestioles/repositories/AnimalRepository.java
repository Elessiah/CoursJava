package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findAllBySpecies(Species species);
    List<Animal> findAllByColorIn(List<String> colors);
    Animal findByName(String name);

    @Query("from Animal WHERE sex = :sex")
    List<Animal> findAllBySex(@Param("sex") String sex);

    @Query("from Animal WHERE SIZE(persons) > 0")
    List<Animal> findAllWithPersons();


    @Query("select case when count(a) > 0 then true ELSE false END from Animal a where a = :animal AND SIZE(a.persons) > 0")
    Boolean hasOwner(@Param("animal") Animal animal);
}
