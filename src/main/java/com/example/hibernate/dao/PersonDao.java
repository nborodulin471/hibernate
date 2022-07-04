package com.example.hibernate.dao;

import com.example.hibernate.model.Person;
import com.example.hibernate.model.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDao extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLivingIgnoreCase(String city);

    List<Person> findByAgeLessThan(int age);

    Optional<Person> findByNameAndSurname(String name, String Surname);
}
