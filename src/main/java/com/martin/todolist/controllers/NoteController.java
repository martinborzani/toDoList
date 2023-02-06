package com.martin.todolist.controllers;


import com.martin.todolist.dto.NoteDTO;
import com.martin.todolist.models.Note;
import com.martin.todolist.models.Person;
import com.martin.todolist.repositories.NoteRepository;
import com.martin.todolist.service.NoteService;
import com.martin.todolist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    PersonService personService;


    @RequestMapping("/note")
    public List<NoteDTO> getNote(){
        return noteService.getNote();
    }


    @PostMapping("/addnote")
    public ResponseEntity<?> addNote(
            @RequestParam String title,
            Authentication authentication
    ){

        Person personCurrent = personService.findByEmail(authentication.getName());


        if(personCurrent == null){
            return new ResponseEntity<>("The person not exist",HttpStatus.FORBIDDEN);
        }

        if(title.isEmpty()){
            return new ResponseEntity<>("The title is empty",HttpStatus.FORBIDDEN);
        }

        Note note = new Note(title,personCurrent);

        noteService.saveNote(note);
        personService.savePerson(personCurrent);




        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/delete")
    public ResponseEntity<?> deleteNote(
            @RequestParam long id,
            Authentication authentication
    ){

        Person personCurrent = personService.findByEmail(authentication.getName());

        if(personCurrent == null){
            return new ResponseEntity<>("The person not found",HttpStatus.FORBIDDEN);
        }

        if(id == 0){
            return new ResponseEntity<>("The id not exits",HttpStatus.FORBIDDEN);
        }


        Note note = noteService.findeById(id);

        if(note == null){
            return new ResponseEntity<>("The Note not found",HttpStatus.FORBIDDEN);
        }

        noteRepository.delete(note);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PostMapping("/editnote")
    public ResponseEntity<?> editNote(
            @RequestParam String title,
            @RequestParam long id,
            Authentication authentication
    ){

        Person personCurrent = personService.findByEmail(authentication.getName());

        if(personCurrent == null){
            return new ResponseEntity<>("The person not found",HttpStatus.FORBIDDEN);
        }

        if(title.isEmpty()){
            return new ResponseEntity<>("The tile is empty",HttpStatus.FORBIDDEN);
        }

        if(id == 0){
            return new ResponseEntity<>("The id not exits",HttpStatus.FORBIDDEN);
        }

        Note note = noteService.findeById(id);

        if(note == null){
            return new ResponseEntity<>("The Note not found",HttpStatus.FORBIDDEN);
        }

        note.setTitle(title);

        noteService.saveNote(note);


        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
