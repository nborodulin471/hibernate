package com.example.hibernate.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
