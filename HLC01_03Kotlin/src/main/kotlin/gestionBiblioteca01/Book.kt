package org.example.gestionBiblioteca01

class Book(
    private val name: String,
    private val author: String?,
    val bookId: Int,
) {

    private var borrowed = false


    fun isBorrowed(): Boolean {
        return borrowed
    }


    fun borrow() {
        borrowed = true
    }


    fun unborrow() {
        borrowed = false
    }


    override fun toString(): String {
        val unavailable = borrowed

        return if (unavailable) {
            "\nNombre: $name\nAutor: $author\nNo Disponible"
        } else {
            "\nNombre: $name\nAutor: $author\nDisponible"
        }

    }

}