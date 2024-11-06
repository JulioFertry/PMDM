package org.example.gestionBiblioteca01

class User(
    val userName: String,
    val userId: Int
) {

    private var currentBook: Book? = null


    fun receiveBook(book: Book) {
        currentBook = book
    }


    fun giveBookBack() {
        currentBook = null
    }


    fun hasBook(): Boolean {
        return (currentBook != null)
    }


    fun getBook(): Book? {
        return currentBook
    }
}