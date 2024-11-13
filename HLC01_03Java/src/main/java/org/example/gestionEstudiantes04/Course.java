package org.example.gestionEstudiantes04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
        Random random = new Random();
        double grade = random.nextDouble() * 10.0;
        student.getCourses().put(this, grade);
    }


    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en el curso " + name + ".");
        } else {
            System.out.println("Estudiantes inscritos en el curso " + name + ":");
            for (Student student : students) {
                Double grade = student.getCourses().get(this);
                System.out.println("Estudiante: " + student.getName() + " - Calificación: " + grade);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

}