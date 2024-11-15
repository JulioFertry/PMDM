package org.example.gestorTareas05;

import java.util.Scanner;


public class TaskMenu {
    private User user;

    public TaskMenu() {
        this.user = new User("Admin");
    }


    private String askForOption() {
        System.out.println("1 para crear una tarea");
        System.out.println("2 para crear un proyecto");
        System.out.println("3 para añadir una tarea a un proyecto");
        System.out.println("4 para marcar una tarea como completada");
        System.out.println("5 para mostrar todas las tareas");
        System.out.println("6 para mostrar todos los proyectos");
        System.out.println("0 para salir");
        System.out.print("----> ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private void performOption(String option) {
        switch (option) {
            case "0":
                System.out.println("Adios");
                break;
            case "1":
                user.createTask();
                break;
            case "2":
                user.createProyect();
                break;
            case "3":
                user.addTaskToProyect();
                break;
            case "4":
                user.markTaskAsCompleted();
                break;
            case "5":
                user.showTasks();
                break;
            case "6":
                user.showProyects();
                break;
            default:
                System.out.println("La opción introducida no existe...");
                break;
        }
    }


    public void executeMenu() {
        String option = "hola";
        try {
            while (!option.equals("0")) {
                option = askForOption();
                performOption(option);
            }
        } catch (Exception e) {
            System.out.println("*** ERROR *** - " + e);
        }
    }


    public static void main(String[] args) {
        org.example.gestionEstudiantes04.SchoolMenu menu = new org.example.gestionEstudiantes04.SchoolMenu();
        menu.executeMenu();
    }

}