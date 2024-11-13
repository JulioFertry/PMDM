package org.example.gestionEstudiantes04

class SchoolMenu {
    private val teacher = Teacher("Profesor")


    private fun askForOption(): String {
        println("1 para añadir estudiante a un curso\n" +
                "2 para calcular las notas de un estudiante\n" +
                "3 para mostrar los estudiantes\n" +
                "4 para mostrar los cursos\n" +
                "0 para salir\n" +
                "----> ")
        val option = readln()
        return option
    }


    private fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> teacher.addStudent()
            "2" -> teacher.showStudentGrades()
            "3" -> teacher.showStudents()
            "4" -> teacher.showCourses()
            else -> println("La opción introducida no existe...")
        }
    }


    fun executeMenu() {
        var option = "hola"
        try {
            while (option != "0") {
                option = askForOption()
                performOption(option)
            }

        } catch (e: Exception) {
            println("*** ERROR *** - $e")
        }
    }

}