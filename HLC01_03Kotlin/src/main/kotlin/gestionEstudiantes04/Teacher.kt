package org.example.gestionEstudiantes04


class Teacher(val nombre: String = "Profesor") {
    private val students = listOf(Student("Pepe"), Student("Juan"), Student("Ana"))
    private val courses = listOf(Course("Matematicas"), Course("Lengua"))

    private fun askForStudent(): String {
        println("introduce el nombre del estudiante: ")
        val student = readln()
        return student
    }


    private fun askForCourse(): String {
        println("introduce el nombre del curso: ")
        val course = readln()
        return course
    }


    fun addStudent() {
        val studentName = askForStudent()
        val student = students.find { it.name == studentName }

        val courseName = askForCourse()
        val course = courses.find { it.name == courseName }

        if (course != null && student != null) {
            course.addStudent(student)
        } else {
            println("No se pudo añadir el estudiante al curso")
        }
    }


    fun showStudentGrades() {
        val studentName = askForStudent()
        val student = students.find { it.name == studentName }
        if (student != null) {
            val grades = student.calcularPromedio()
            println("la nota media de ${student.name} es de $grades")
        } else {
            println("No se pudo calcular la nota")
        }
    }


    fun showStudents() {
        println("Estudiantes:")
        for (student in students) {
            println(student.name)
        }
    }


    fun showCourses() {
        println("Cursos:")
        for (course in courses) {
            println(course.name)
        }
    }

}
