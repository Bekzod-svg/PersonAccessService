package com.example.demo3.dao;

import com.example.demo3.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPersonsList() {
        String sql = "SELECT id, name FROM person";
        List<Person> personList= jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
        return personList;
    }

    @Override
    public Optional<Person> getPerson(UUID id) {
        String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (res, i) -> {
            UUID newId = UUID.fromString(res.getString("id"));
            String name = res.getString("name");
            return new Person(newId, name);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public void addPerson(UUID id, Person person) {
        String sql = "INSERT INTO person (id, name) VALUES (?, ?)";
        jdbcTemplate.update(sql, id, person.getName());
    }

    @Override
    public void updatePerson(UUID id, Person person) {
        String sql = "UPDATE person SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, person.getName(), id);
    }

    @Override
    public void deletePerson(UUID id) {
        String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
