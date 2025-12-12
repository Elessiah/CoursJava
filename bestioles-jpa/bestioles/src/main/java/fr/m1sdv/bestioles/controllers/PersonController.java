package fr.m1sdv.bestioles.controllers;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Person;
import fr.m1sdv.bestioles.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/person")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person create(@Valid @RequestBody Person person) {
        return personService.Create(person);
    }

    @PutMapping
    public Person update(@Valid @RequestBody Person person) {
        return personService.Update(person);
    }

    @GetMapping({"/{id}"})
    public Person getPerson(@PathVariable("id") Integer id) {
        return this.personService.findById(id);
    }

    @DeleteMapping({"/{id}"})
    public void deletePerson(@PathVariable("id") Integer id) {
        this.personService.deleteById(id);
    }

    @GetMapping()
    public List<Person> getPersons() {
        return this.personService.findAll();
    }

    @GetMapping({"/names{firstname}{lastname}"})
    public List<Person> findAllByFirstNameOrLastname(String firstName, String lastName) {
        return this.personService.findAllByFirstnameOrLastname(firstName, lastName);
    }

    @GetMapping({"/minage{age}"})
    public List<Person> findAllByAgeGreaterThanEqual(Integer age) {
        return this.personService.findAllByAgeGreaterThanEqual(age);
    }

    @DeleteMapping({"/firstname{firstname}"})
    public void deleteAllByFirstName(String firstName) {
        this.personService.deleteAllByFirstname(firstName);
    }

    @GetMapping({"/betweenage{min}{max}"})
    public List<Person> findAllByAgeBetween(Integer first, Integer last) {
        return this.personService.findAllByAgeBetween(first, last);
    }
}
