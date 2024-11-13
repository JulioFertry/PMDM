package org.example.gestionEstudiantes04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Teacher {
    private String nombre;
    private List<Student> students;
    private List<Course> courses;

    public Teacher(String nombre) {
        this.nombre = nombre != null ? nombre : "Profesor";
        this.students = Arrays.asList(
                new Student("Pepe"),
                new Student("Juan"),
                new Student("Ana")
        );
        this.courses = Arrays.asList(
                new Course("Matematicas"),
                new Course("Lengua")
        );
    }


    private String askForStudent() {
        System.out.println("Introduce el nombre del estudiante: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    private String askForCourse() {
        System.out.println("Introduce el nombre del curso: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public void addStudent() {
        String studentName = askForStudent();
        Student student = students.stream()
                .filter(s -> s.getName().equals(studentName))
                .findFirst()
                .orElse(null);

        String courseName = askForCourse();
        Course course = courses.stream()
                .filter(c -> c.getName().equals(courseName))
                .findFirst()
                .orElse(null);

        if (course != null && student != null) {
            course.addStudent(student);
        } else {
            System.out.println("No se pudo añadir el estudiante al curso");
        }
    }


    public void showStudentGrades() {
        String studentName = askForStudent();
        Student student = students.stream()
                .filter(s -> s.getName().equals(studentName))
                .findFirst()
                .orElse(null);

        if (student != null) {
            Double grades = student.calcularPromedio();
            System.out.println("La nota media de " + student.getName() + " es de " + grades);
        } else {
            System.out.println("No se pudo calcular la nota");
        }
    }


    public void showStudents() {
        System.out.println("Estudiantes:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }


    public void showCourses() {
        System.out.println("Cursos:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }


    public static void main(String[] args) {
        Teacher teacher = new Teacher("Profesor");
        teacher.showStudents();
        teacher.showCourses();
        teacher.addStudent();
        teacher.showStudentGrades();
    }

}