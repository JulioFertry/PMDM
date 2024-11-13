package org.example.gestorTareas05

class Proyect(val name: String) {
    private val tasks = mutableListOf<Task>()


    fun addTask(task: Task) {
        tasks.add(task)
        println("Tarea añadida a $name")
    }

    override fun toString(): String {
        return "Proyecto: $name ${tasks.forEach { println("        $it") }}"
    }

}