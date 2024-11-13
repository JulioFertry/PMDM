package org.example.gestorTareas05

class Task(val name: String, val id: String) {
    private var completed = false


    fun markAsCompleted() {
        completed = true
        println("$name finalizado")
    }

    override fun toString(): String {
        return "Tarea: $name, ID: $id, ${if (completed){"Finalizada"}else{"Pendiente"}}"
    }

}