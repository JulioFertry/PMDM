package org.example.gestorTareas05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private int taskCounter = 0;
    private List<Proyect> proyects = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public User(String name) {
        this.name = name;
    }


    public void createTask() {
        System.out.print("Introduce el nombre de la tarea: ");
        String newTaskName = scanner.nextLine();
        Task newTask = new Task(newTaskName, Integer.toString(taskCounter));
        tasks.add(newTask);
        System.out.println("Se ha creado la tarea " + newTaskName + " con el ID: " + taskCounter);
        taskCounter++;
    }


    public void createProyect() {
        System.out.print("Introduce el nombre del proyecto: ");
        String newProyectName = scanner.nextLine();
        Proyect newProyect = new Proyect(newProyectName);
        proyects.add(newProyect);
    }


    public void addTaskToProyect() {
        System.out.print("Introduce el ID de la tarea: ");
        String taskId = scanner.nextLine();
        Task task = findTaskById(taskId);

        System.out.print("Introduce el nombre del proyecto: ");
        String proyectName = scanner.nextLine();
        Proyect proyect = findProyectByName(proyectName);

        if (task != null && proyect != null) {
            proyect.addTask(task);
        } else {
            System.out.println("No se pudo añadir la tarea");
        }
    }


    public void markTaskAsCompleted() {
        System.out.print("Introduce el id de la tarea: ");
        String taskId = scanner.nextLine();
        Task task = findTaskById(taskId);

        if (task != null) {
            task.markAsCompleted();
        } else {
            System.out.println("No se encontró la tarea");
        }
    }


    public void showProyects() {
        for (Proyect proyect : proyects) {
            System.out.println(proyect.toString());
        }
    }


    public void showTasks() {
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
    }


    private Task findTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }


    private Proyect findProyectByName(String proyectName) {
        for (Proyect proyect : proyects) {
            if (proyect.getName().equals(proyectName)) {
                return proyect;
            }
        }
        return null;
    }

}