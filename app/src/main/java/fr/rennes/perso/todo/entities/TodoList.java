package fr.rennes.perso.todo.entities;

import android.text.format.DateFormat;

/**
 * Created by Dereck on 17/08/2017.
 */

public class TodoList {
    private int id;
    private String name;
    private DateFormat creationDate;

    public TodoList() {
    }

    public TodoList(String name, DateFormat creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateFormat getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateFormat creationDate) {
        this.creationDate = creationDate;
    }
}
