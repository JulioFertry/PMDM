package org.example.gestionEstudiantes04

class Student(val name: String) {
    val courses = mutableMapOf<Course, Double>()
    private var averageGrades: Double? = 0.0


    fun calcularPromedio(): Double? {
        val grades = if (courses.isEmpty()) {
            null
        } else {
            courses.values.average()
        }

        averageGrades = grades
        return grades
    }
}
