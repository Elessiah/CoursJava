package fr.m1sdv.bestioles.repositories;

import fr.m1sdv.bestioles.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonRepositoryImpl implements PersonRepositoryCustom {
    @PersistenceContext
    private EntityManager em;
    private List<String> names;

    public PersonRepositoryImpl(EntityManager em) {
        this.em = em;
        names = List.of("Liora", "Soren", "Elian", "Maeva", "Kael", "Neris", "Althéa", "Darian", "Lyra", "Eamon", "Selene", "Arthus", "Mira", "Taren", "Isolde", "Calen", "Nyra", "Edris", "Sylas", "Alera");
    }

    @Override
    public int deleteWithoutAnimals() {
        List<Integer> ids = em.createQuery("SELECT p.id from Person p WHERE p.animals IS EMPTY", Integer.class).getResultList();
        return em.createQuery("DELETE FROM Person p WHERE p.id IN :ids").setParameter("ids", ids).executeUpdate();
    }

    @Override
    public List<Person> generatePerson(int number) {
        List<Person> persons = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            Person person = new Person();
            person.setFirstname(names.get(random.nextInt(names.size())));
            person.setLastname(names.get(random.nextInt(names.size())));
            person.setAge(random.nextInt(100));
            person.setLogin(names.get(random.nextInt(names.size())).toLowerCase() + random.nextInt(99999));
            person.setMdp(names.get(random.nextInt(names.size())));
            person.setActive(true);
            em.persist(person);
            persons.add(person);
        }
        return persons;
    }
}
