package com.martin.todolist.service;

import com.martin.todolist.dto.PersonDTO;
import com.martin.todolist.models.Person;

import java.util.List;

public interface PersonService {


    List<PersonDTO> getPersons();


    Person findByEmail(String email);
    public void savePerson(Person person);



}
