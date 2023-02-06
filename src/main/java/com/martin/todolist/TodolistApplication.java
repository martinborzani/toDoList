package com.martin.todolist;

import com.martin.todolist.models.Note;
import com.martin.todolist.models.Person;
import com.martin.todolist.repositories.PersonRepository;
import com.martin.todolist.service.NoteService;
import com.martin.todolist.service.PersonService;
import org.aspectj.bridge.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}


	@Autowired
	PersonService personService;

	@Autowired
	NoteService noteService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(PersonRepository personRepository){
		return args ->{



			Person persona1 = new Person("Martin","Borzani","martinborzani0@gmail.com", passwordEncoder.encode("1234"));
			Person persona2 = new Person("Nicolas","Borzani","nicolas@gmail.com", passwordEncoder.encode("1234"));
			personService.savePerson(persona1);
			personService.savePerson(persona2);

			Note nota1 = new Note("Hacer la tarea del hogar",persona1);
			Note nota2 = new Note("Hacer la tarea del colegio",persona1);
			Note nota3 = new Note("Lavar el auto",persona2);
			Note nota4 = new Note("Ir al gym",persona2);

			noteService.saveNote(nota1);
			noteService.saveNote(nota2);
			noteService.saveNote(nota3);
			noteService.saveNote(nota4);



		};
	}

}
