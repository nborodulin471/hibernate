package com.example.hibernate.dao;

import com.example.hibernate.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("select p from Person p where lower(p.cityOfLiving ) = lower(?1)")
                .setParameter(1, city)
                .getResultList();
    }
}
