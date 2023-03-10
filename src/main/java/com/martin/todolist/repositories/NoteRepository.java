package com.martin.todolist.repositories;


import com.martin.todolist.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface NoteRepository extends JpaRepository<Note,Long> {


        Note findById(long id);


}
