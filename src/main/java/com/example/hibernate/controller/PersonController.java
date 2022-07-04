package com.example.hibernate.controller;

import com.example.hibernate.dao.PersonDao;
import com.example.hibernate.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonDao personDao;

    @GetMapping("/persons/by-city")
    ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        return ResponseEntity.ok(personDao.findByCityOfLivingIgnoreCase(city));
    }

    @GetMapping("/persons/by-younger-age")
    ResponseEntity<List<Person>> getPersonsByYoungerAge(@RequestParam int age) {
        return ResponseEntity.ok(personDao.findByAgeLessThan(age));
    }

    @GetMapping("/person/by-name")
    ResponseEntity<Person> getPersonsByCity(@RequestParam String name, @RequestParam String surname) {
        return personDao.findByNameAndSurname(name, surname)
                .map(person -> ResponseEntity.ok().body(person))
                .orElseGet(() -> (ResponseEntity<Person>) ResponseEntity.notFound());
    }
}
