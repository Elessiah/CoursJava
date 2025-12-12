package fr.m1sdv.bestioles.services;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Person;
import fr.m1sdv.bestioles.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person Create(Person person) {
        return personRepository.save(person);
    }

    public Person Update(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public List<Person> findAllByFirstnameOrLastname(String firstName, String lastName) {
        return personRepository.findAllByFirstnameOrLastname(firstName, lastName);
    }

    public List<Person> findAllByAgeGreaterThanEqual(Integer age) {
        return personRepository.findAllByAgeGreaterThanEqual(age);
    }

    public void deleteAllByFirstname(String firstName) {
        personRepository.deleteAllByFirstname(firstName);
    }

    public List<Person> findAllByAgeBetween(Integer first, Integer last) {
        return personRepository.findAllByAgeBetween(first, last);
    }
}
