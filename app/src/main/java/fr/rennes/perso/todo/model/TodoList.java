package fr.rennes.perso.todo.model;

import java.util.Date;

/**
 * Created by Dereck on 17/08/2017.
 */

public class TodoList {
    /** TodoList table information */
    public static final String TABLE = "lists";
    public static final String COLUMN_LIST_ID = "id";
    public static final String COLUMN_LIST_NAME = "name";
    public static final String COLUMN_LIST_CDATE = "creationDate";

    /** TodoList values */
    private int id;
    private String name;
    private Date creationDate;

    /** Constructor */
    public TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
        this.creationDate = new Date();
    }

    public TodoList(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public TodoList(int id, String name, Date creationDate){
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    /** Getter & Setter */
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
