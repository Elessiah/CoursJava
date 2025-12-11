package fr.m1sdv.bestioles.boot;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Person;
import fr.m1sdv.bestioles.model.Species;
import fr.m1sdv.bestioles.repositories.AnimalRepository;
import fr.m1sdv.bestioles.repositories.PersonRepository;
import fr.m1sdv.bestioles.repositories.RoleRepository;
import fr.m1sdv.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
public class Startup implements CommandLineRunner {
    private AnimalRepository animalRepository;
    private PersonRepository personRepository;
    private RoleRepository roleRepository;
    private SpeciesRepository speciesRepository;

    @Autowired
    public Startup(AnimalRepository animalRepository,
                   PersonRepository personRepository,
                   RoleRepository roleRepository,
                   SpeciesRepository speciesRepository) {
        this.animalRepository = animalRepository;
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.speciesRepository = speciesRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("\u001B[34mRetrieving animals : \u001B[0m" + this.animalRepository.findAll());
        System.out.println("\u001B[34mRetrieving persons : \u001B[0m" + this.personRepository.findAll());
        System.out.println("\u001B[34mRetrieving roles : \u001B[0m" + this.roleRepository.findAll());
        System.out.println("\u001B[34mRetrieving species : \u001B[0m" + this.speciesRepository.findAll());

        System.out.println("\u001B[34mCount animal before insert : \u001B[0m" + this.animalRepository.count());

        Animal animal = new Animal();
        animal.setName("Coleen");
        animal.setColor("orange");
        animal.setSex("female");
        Species chat = speciesRepository.findFirstByCommonName("Chat");
        System.out.println("\u001B[34mChat: \u001B[0m" + chat);
        animal.setSpecies(chat);
        animalRepository.save(animal);

        System.out.println("\u001B[34mInserting animal : \u001B[0m" + animal.getName());
        System.out.println("\u001B[34mCount animal after insert : \u001B[0m" + this.animalRepository.count());

        animalRepository.delete(animal);

        System.out.println("\u001B[34mDeleting animal : \u001B[0m" + animal.getName());
        System.out.println("\u001B[34mCount animal after delete : \u001B[0m" + this.animalRepository.count());
        System.out.println("\u001B[34mFetching : felis silvestris catus\u001B[0m");
        List<Species> CatSpecies = speciesRepository.findAllByLatinNameIgnoreCase("felis silvestris catus");
        for (Species species : CatSpecies) {
            System.out.println("Retrieved : " + species);
        }

        List<Person> personList = personRepository.findAllByFirstnameOrLastname("Sophie", "Lamarque");
        System.out.println("\u001B[34mRetrieving persons : \u001B[0mSophie, Lamarque");
        for (Person person : personList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + person);
        }
        System.out.println("\u001B[34mRetrieving persons with age greater or equal than :\u001B[0m 45");
        personList = personRepository.findAllByAgeGreaterThanEqual(45);
        for (Person person : personList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + person);
        }
        System.out.println("\u001B[34mFetching Animal of Species : Chat\u001B[0m");
        List<Animal> animals = animalRepository.findAllBySpecies(chat);
        for (Animal fanimal : animals) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + fanimal);
        }

        System.out.println("\u001B[34mFetching Animal of Color : \u001B[0mNoir, Blanc");
        List<String> colors = List.of("Blanc", "Noir");
        animals = animalRepository.findAllByColorIn(colors);
        for (Animal fanimal : animals) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + fanimal);
        }

        System.out.println("\u001B[34mFetching Species Order by common name ascendant : \u001B[0m");
        List<Species> speciesList = speciesRepository.findAllOrderByCommonNameAsc();
        for (Species species : speciesList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + species);
        }

        System.out.println("\u001B[34mFetching Species : \u001B[0m Chat");
        speciesList = speciesRepository.findAllByCommonName("Chat");
        for (Species species : speciesList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + species);
        }

        System.out.println("\u001B[34mFetching Persons who has : \u001B[0m Chat");
        animal = animalRepository.findByName("Max");
        personList = personRepository.findAllByAnimal(animal);
        for (Person person : personList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + person);
        }

        System.out.println("\u001B[34mFetching Persons with age between : \u001B[0m40 et  50");
        personList = personRepository.findAllByAgeBetween(40, 50);
        for (Person person : personList) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + person);
        }

        System.out.println("\u001B[34mFetching Animals link to at least one person : \u001B[0m");
        animals = animalRepository.findAllWithPersons();
        for (Animal fanimal : animals) {
            System.out.println("\u001B[34mRetrieved : \u001B[0m" + fanimal);
        }


        System.out.println("\u001B[34mCheck if \u001B[0mMax\u001B[34m has owner : \u001B[0m" + animalRepository.hasOwner(animal));

        personRepository.generatePerson(5);
        personRepository.deleteWithoutAnimals();
    }
}
