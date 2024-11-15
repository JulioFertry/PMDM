package org.example.gestorTareas05;

import java.util.ArrayList;

class Proyect {
    private ArrayList<Task> tasks;
    private String name;

    public Proyect(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }


    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Tarea añadida a " + this.name);
    }


    @Override
    public String toString() {
        StringBuilder tasksString = new StringBuilder();
        tasks.forEach(task -> tasksString.append("\n    " + task.toString()));

        return "Proyecto " + this.name + tasksString;
    }

}