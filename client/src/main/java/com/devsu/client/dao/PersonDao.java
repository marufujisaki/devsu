package com.devsu.client.dao;

import com.devsu.client.entities.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
    Person findById(int id);
    Person save(Person person);
    void deleteById(int id);
}
