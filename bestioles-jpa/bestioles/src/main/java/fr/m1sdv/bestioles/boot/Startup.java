package fr.m1sdv.bestioles.boot;

import fr.m1sdv.bestioles.model.Animal;
import fr.m1sdv.bestioles.model.Species;
import fr.m1sdv.bestioles.repositories.AnimalRepository;
import fr.m1sdv.bestioles.repositories.PersonRepository;
import fr.m1sdv.bestioles.repositories.RoleRepository;
import fr.m1sdv.bestioles.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

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
    public void run(String... args) throws Exception {
        System.out.println("Retrieving animals : " + this.animalRepository.findAll());
        System.out.println("Retrieving persons : " + this.personRepository.findAll());
        System.out.println("Retrieving roles : " + this.roleRepository.findAll());
        System.out.println("Retrieving species : " + this.speciesRepository.findAll());

        System.out.println("Count animal before insert : " + this.animalRepository.count());

        Animal animal = new Animal();
        animal.setName("Coleen");
        animal.setColor("orange");
        animal.setSex("female");
        Iterable<Species> species = this.speciesRepository.findAll();
        animal.setSpecies(species.iterator().next());
        animalRepository.save(animal);

        System.out.println("Inserting animal : " + animal.getName());
        System.out.println("Count animal after insert : " + this.animalRepository.count());

        animalRepository.delete(animal);

        System.out.println("Deleting animal : " + animal.getName());
        System.out.println("Count animal after delete : " + this.animalRepository.count());
    }
}
