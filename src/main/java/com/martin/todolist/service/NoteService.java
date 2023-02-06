package com.martin.todolist.service;

import com.martin.todolist.dto.NoteDTO;
import com.martin.todolist.models.Note;

import java.util.List;

public interface NoteService {


    List<NoteDTO> getNote();

    void saveNote(Note note);

    Note findeById(long id);

}
