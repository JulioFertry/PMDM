package org.example.gestionEstudiantes04;

import java.util.Scanner;


public class SchoolMenu {
    private Teacher teacher;

    public SchoolMenu() {
        this.teacher = new Teacher("Profesor");
    }


    private String askForOption() {
        System.out.println("1 para añadir estudiante a un curso");
        System.out.println("2 para calcular las notas de un estudiante");
        System.out.println("3 para mostrar los estudiantes");
        System.out.println("4 para mostrar los cursos");
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
                teacher.addStudent();
                break;
            case "2":
                teacher.showStudentGrades();
                break;
            case "3":
                teacher.showStudents();
                break;
            case "4":
                teacher.showCourses();
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
        SchoolMenu menu = new SchoolMenu();
        menu.executeMenu();
    }

}