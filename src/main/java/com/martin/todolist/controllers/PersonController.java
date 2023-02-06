package com.martin.todolist.controllers;


import com.martin.todolist.dto.PersonDTO;
import com.martin.todolist.models.Person;
import com.martin.todolist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("/persons")
    public List<PersonDTO> getPersons(){
       return personService.getPersons();
    }

    @RequestMapping("/personcurrent")
    public PersonDTO getPersonCurrent(Authentication authentication){
        Person personCurrent = personService.findByEmail(authentication.getName());
        return new PersonDTO(personCurrent);
    }


}
