package gestorTareas05

import org.example.gestorTareas05.User


class TaskMenu {
    private val user = User("Juan")


    private fun askForOption(): String {
        println("1 Crea una tarea\n" +
                "2 Crea un proyecto\n" +
                "3 Añade una tarea a un proyecto\n" +
                "4 Marca una tarea como completada\n" +
                "5 Muestra todos los proyectos\n" +
                "6 Muestra todas las tareas\n" +
                "0 Para salir\n" +
                "----> ")
        val option = readln()
        return option
    }


    private fun performOption(option: String) {
        when (option) {
            "0" -> println("Adios")
            "1" -> user.createTask()
            "2" -> user.createProyect()
            "3" -> user.addTaskToProyect()
            "4" -> user.markTaskAsCompleted()
            "5" -> user.showProyects()
            "6" -> user.showTasks()
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