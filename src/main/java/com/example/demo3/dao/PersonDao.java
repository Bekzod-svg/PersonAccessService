package com.example.demo3.dao;

import com.example.demo3.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

public interface PersonDao {
    List<Person> getPersonsList();
    Optional<Person> getPerson(UUID id);
    void updatePerson(UUID id, Person person);
    void deletePerson(UUID id);
    void addPerson(UUID id, Person person);
    default void addPerson(Person person){
        UUID id = UUID.randomUUID();
        addPerson(id, person);
    }

}
