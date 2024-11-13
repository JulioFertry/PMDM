package org.example.gestionEstudiantes04;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Course, Double> courses;
    private Double averageGrades;

    public Student(String name) {
        this.name = name;
        this.courses = new HashMap<>();
        this.averageGrades = 0.0;
    }


    public Double calcularPromedio() {
        if (courses.isEmpty()) {
            return null;
        } else {
            double average = courses.values().stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
            averageGrades = average;
            return average;
        }
    }


    public String getName() {
        return name;
    }


    public Map<Course, Double> getCourses() {
        return courses;
    }


    public Double getAverageGrades() {
        return averageGrades;
    }

}