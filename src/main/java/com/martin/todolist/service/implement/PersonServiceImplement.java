package com.martin.todolist.service.implement;

import com.martin.todolist.dto.PersonDTO;
import com.martin.todolist.models.Person;
import com.martin.todolist.repositories.PersonRepository;
import com.martin.todolist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImplement implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<PersonDTO> getPersons() {
        return personRepository.findAll().stream().map(person -> new PersonDTO(person)).collect(Collectors.toList());
    }

    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
