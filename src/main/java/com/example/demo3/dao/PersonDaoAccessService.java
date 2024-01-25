package com.example.demo3.dao;

import com.example.demo3.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personDao")
public class PersonDaoAccessService implements PersonDao {
    private static List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getPersonsList(){
        return personList;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        return personList.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public void addPerson(UUID id, Person person) {
        personList.add(new Person(id, person.getName()));
    }

    @Override
    public void updatePerson(UUID id, Person person) {
        for(int i=0;i<personList.size();i++){
            if(personList.get(i).equals(person.getId())){
                personList.set(i, person);
                return;
            }
        }
    }

    @Override
    public void deletePerson(UUID id) {
//        Person person = personList.stream().filter(person1 -> person1.getId().equals(id)).findFirst().get();
        for (int i=0;i<personList.size();i++){
            if(personList.get(i).getId().equals(id)){
                personList.remove(i);
                return;
            }
        }
    }
}
