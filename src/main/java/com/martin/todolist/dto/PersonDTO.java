package com.martin.todolist.dto;

import com.martin.todolist.models.Person;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonDTO {


    private long id;

    private String name;

    private String lastname;

    private String email;

    private String password;

    private Set<NoteDTO> notes = new HashSet<>();


    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.lastname = person.getLastname();
        this.email = person.getEmail();
        this.notes = person.getNote().stream().map(note -> new NoteDTO(note)).collect(Collectors.toSet());

    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<NoteDTO> getNotes() {
        return notes;
    }
}
