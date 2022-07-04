package com.example.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@IdClass(PersonId.class)
public class Person implements Serializable {
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private int age;

    private String cityOfLiving;
    @Nullable
    private int phoneNumber;
}
