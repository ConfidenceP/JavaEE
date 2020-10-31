package me.confidence.service;

import me.confidence.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PersonService {

    @PersistenceContext
    EntityManager entityManager;

    public Person addPerson(Person person) {
        entityManager.persist(person);
        return person;
    }

    public Person updatePerson(Person person) {
        entityManager.merge(person);
        return person;
    }

    public Person findPersonById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> getPeople() {
        return entityManager.createQuery("SELECT t FROM Person t", Person.class).getResultList();
    }

}
