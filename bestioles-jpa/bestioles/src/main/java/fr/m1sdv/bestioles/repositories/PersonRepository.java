package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {
    List<Person> findAllByFirstnameOrLastname(String firstname, String lastname);
    List<Person> findAllByAgeGreaterThanEqual(int age);

    @Modifying
    void deleteAllByFirstname(String firstname);

    @Query("from Person WHERE age between :agemin and :agemax")
    List<Person> findAllByAgeBetween(@Param("agemin") int age, @Param("agemax") int agemax);

    @Query("from Person WHERE :pet MEMBER OF animals")
    List<Person> findAllByAnimal(@Param("pet") Animal pet);
}
