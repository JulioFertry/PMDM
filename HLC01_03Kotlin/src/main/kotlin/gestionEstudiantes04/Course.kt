package org.example.gestionEstudiantes04

import kotlin.random.Random

class Course(val name: String) {
    private val students = mutableListOf<Student>()


    fun addStudent(student: Student) {
        students.add(student)
        student.courses[this] = Random.nextDouble(0.0, 10.0)
    }


}