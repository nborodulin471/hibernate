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
        return ResponseEntity.ok(personDao.getPersonsByCity(city));
    }
}
