package fr.rennes.perso.todo.model;

/**
 * Created by Dereck on 17/08/2017.
 */

public class TodoTask {
    private int id;
    private String task;
    private String description;
    private Boolean state;
    private int id_list;

    public TodoTask() {
    }

    public TodoTask(String task, String description, Boolean state) {
        this.task = task;
        this.description = description;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getId_list() {
        return id_list;
    }

    public void setId_list(int id_list) {
        this.id_list = id_list;
    }

}
