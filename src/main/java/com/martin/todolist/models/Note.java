package com.martin.todolist.models;

import ch.qos.logback.core.net.server.Client;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Note {


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
     @GenericGenerator(name="native",strategy = "native")
     private long id;

     private String title;

     private boolean disable = true;



     @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name="person_id")
     private Person person;





    public Note() {
    }

    public Note(String title,Person person) {

        this.title = title;
        this.person = person;
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


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
