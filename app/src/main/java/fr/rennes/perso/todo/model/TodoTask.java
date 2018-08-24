package fr.rennes.perso.todo.model;

public class TodoTask extends EntityBase {
    private String name;
    private String description;
    private Boolean state;

    public TodoTask() {
    }

    public TodoTask(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public TodoTask setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TodoTask setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getState() {
        return state;
    }

    public TodoTask setState(Boolean state) {
        this.state = state;
        return this;
    }
}
