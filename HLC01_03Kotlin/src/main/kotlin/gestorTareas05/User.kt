package org.example.gestorTareas05

class User(val name: String) {
    private var taskCounter = 0
    private val proyects = mutableListOf<Proyect>()
    private val tasks = mutableListOf<Task>()


    fun createTask() {
        print("Introduce el nombre de la tarea: ")
        val newTaskName = readln()
        val newTask = Task(newTaskName, taskCounter.toString())
        tasks.add(newTask)
        println("Se ha creado la tarea $newTaskName con el ID: $taskCounter")

        taskCounter += 1
    }


    fun createProyect() {
        print("Introduce el nombre del proyecto: ")
        val newProyectName = readln()
        val newProyect = Proyect(newProyectName)
        proyects.add(newProyect)
    }


    fun addTaskToProyect() {
        print("Introduce el ID de la tarea: ")
        val taskId = readln()
        val task = tasks.find { it.id == taskId }

        print("Introduce el nombre del proyecto: ")
        val proyectName = readln()
        val proyect = proyects.find { it.name == proyectName }

        if (task != null && proyect != null) {
            proyect.addTask(task)
        } else {
            println("No se pudo añadir la tarea")
        }

    }


    fun markTaskAsCompleted() {
        print("Introduce el id de la tarea: ")
        val taskId = readln()

        val task = tasks.find { it.id == taskId }

        if (task != null) {
            task.markAsCompleted()
        } else {
            println("No se encontró la tarea")
        }

    }


    fun showProyects() {
        for (proyect in proyects) {
            println(proyect.toString())
        }
    }


    fun showTasks() {
        for (task in tasks) {
            println(task.toString())
        }
    }

}