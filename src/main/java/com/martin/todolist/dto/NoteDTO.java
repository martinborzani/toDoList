package com.martin.todolist.dto;

import com.martin.todolist.models.Note;

public class NoteDTO {

    private long id;

    private String title;

    private boolean disable;




    public NoteDTO() {
    }

    public NoteDTO(Note note) {
        this.id = note.getId();
        this.title = note.getTitle();
        this.disable = note.isDisable();
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}


