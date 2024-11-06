package org.example.gestionBiblioteca01


class Library(
    val books: MutableList<Book> = mutableListOf(),
    val users: MutableList<User> = mutableListOf()
) {

    fun addBook(name: String, author: String?) {
        val id = if (books == emptyList<Book>()) {
            0
        } else {
            books.last().bookId + 1
        }

        val newBook = Book(name, author, id)
        books.add(newBook)
    }


    fun registerUser(name: String) {
        val id = if (users == emptyList<User>()) {
            0
        } else {
            users.last().userId + 1
        }

        val newUser = User(name, id)
        users.add(newUser)
    }


    fun borrowBook(bookId: Int, userId: Int) {
        try {
            val book = books.find { it.bookId == bookId }
            if (book == null) {
                throw Exception("No existe el libro")
            }

            val user = users.find { it.userId == userId }
            if (user == null) {
                throw Exception("No existe el usuario")
            }

            if (book.isBorrowed()) {
                println("El libro ya está prestado")
            } else if (user.hasBook()) {
                println("El usuario ya tiene un libro")
            } else {
                user.receiveBook(book)
                book.borrow()
            }
        } catch (e: Exception) {
            println("*** ERROR *** ($e)")
        }

    }


    fun returnBook(userId: Int) {
        try {
            val user = users.find { it.userId == userId }
            if (user == null) {
                throw Exception("No existe el usuario")
            }

            val book = user.getBook()

            if (book != null) {
                book.unborrow()
                user.giveBookBack()
            } else {
                println("Este usuario no tiene ningún libro")
            }
        } catch (e: Exception) {
            println("*** ERROR *** - ($e)")
        }

    }


    fun showAllBooks() {
        books.forEach { println(it.toString()) }
    }

}