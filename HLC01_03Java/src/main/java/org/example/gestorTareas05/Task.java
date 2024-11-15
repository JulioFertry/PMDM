package org.example.gestorTareas05;

public class Task {
    private Boolean completed;
    private String name;
    private String id;


    public Task(String name, String id) {
        this.name = name;
        this.id = id;
        this.completed = false;
    }


    public String getName() {
        return this.name;
    }


    public String getId() {
        return this.id;
    }


    public void markAsCompleted() {
        completed = true;
        System.out.println(this.name + " finalizado");
    }


    private String isCompletedTaskString() {
        if (completed) {
            return "Finalizado";
        } else {
            return "Pendiente";
        }
    }


    @Override
    public String toString() {
        return "Tarea: " + this.name + " ID: " + this.id + " Estado: " + isCompletedTaskString();
    }

}