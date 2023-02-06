package com.martin.todolist.repositories;


import com.martin.todolist.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findByEmail(String email);
}
