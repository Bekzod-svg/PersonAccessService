package com.example.demo3.service;

import com.example.demo3.dao.PersonDao;
import com.example.demo3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public void setPersonDao(@Qualifier("postgres") PersonDao personDao){
        this.personDao = personDao;
    }

    public void addPerson(Person person){
        personDao.addPerson(person);
    }

    public List<Person> getPersonList(){
        return personDao.getPersonsList();
    }

    public Optional<Person> getPerson(UUID id){
        return personDao.getPerson(id);
    }

    public void updatePerson(UUID id, Person person){
        personDao.updatePerson(id, person);
    }

    public void deletePerson(UUID id){
        personDao.deletePerson(id);
    }


}
