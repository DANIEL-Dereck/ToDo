package fr.rennes.perso.todo.model;

import java.util.List;

public class TodoList extends EntityBase{
    private String name;
    private List<TodoTask> tasks;

    public TodoList() {
    }

    public TodoList(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TodoTask> getTasks() {
        return tasks;
    }

    public TodoList setTasks(List<TodoTask> tasks) {
        this.tasks = tasks;
        return this;
    }
}
