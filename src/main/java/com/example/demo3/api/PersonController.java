package com.example.demo3.api;

import com.example.demo3.model.Person;
import com.example.demo3.service.PersonService;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    private PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPersonsList(){
        return personService.getPersonList();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Person getPerson(@PathVariable("id") UUID id){
        return personService.getPerson(id).orElse(null);
    }

    @PostMapping
    public void addPerson(@Nonnull @Validated @RequestBody Person person){
        personService.addPerson(person);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public void updatePerson(@Nonnull @Validated @RequestBody Person person, @PathVariable("id") UUID id){
        personService.updatePerson(id, person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

}
