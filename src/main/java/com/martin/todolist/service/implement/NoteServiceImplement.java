package com.martin.todolist.service.implement;

import com.martin.todolist.dto.NoteDTO;
import com.martin.todolist.models.Note;
import com.martin.todolist.repositories.NoteRepository;
import com.martin.todolist.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteServiceImplement implements NoteService {

    @Autowired
    NoteRepository noteRepository;


    @Override
    public List<NoteDTO> getNote() {
        return noteRepository.findAll().stream().map(note -> new NoteDTO(note)).collect(Collectors.toList());
    }

    @Override
    public void saveNote(Note note) {
        noteRepository.save(note);
    }

    @Override
    public Note findeById(long id) {
        return noteRepository.findById(id);
    }
}
