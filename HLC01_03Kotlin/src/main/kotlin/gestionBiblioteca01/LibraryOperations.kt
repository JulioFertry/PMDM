package org.example.gestionBiblioteca01

class LibraryOperations {
    private val library = Library()

    private fun initializeExampleLibrary00() {
        library.books.add(Book("El lazarillo de tormes", null, 1))
        library.books.add(Book("1984", "George Orwell", 2))
        library.books.add(Book("Alice in Wonderland", "Lewis Carroll", 3))
        library.books.add(Book("The Lord of the Rings", "J.R.R Tolkien", 4))
        library.books.add(Book("Divina Commedia", "Dante Alighieri", 5))

        library.users.add(User("Pepe", 1))
        library.users.add(User("Juan", 2))
        library.users.add(User("Eustaquio", 3))
    }


    private fun addBook01() {
        print("Introduce el nombre del libro: ")
        val name = readln()
        print("Introduce el nombre del autor: ")
        val author = readln()
        library.addBook(name, author)
    }


    private fun addUser02() {
        print("Introduce el nombre del usuario: ")
        val name = readln()
        library.registerUser(name)
    }


    private fun borrowBook03() {
        try {
            print("Introduce el id del libro: ")
            val bookId = readln().toInt()

            print("Introduce el id del usuario: ")
            val userId = readln().toInt()

            library.borrowBook(bookId, userId)
        } catch (e: NumberFormatException) {
            println("*** ERROR *** - Has introducido un id no numérico")
        }
    }


    private fun returnBook04() {
        try {
            print("Introduce el id del libro: ")
            val userId = readln().toInt()

            library.returnBook(userId)
        } catch (e: NumberFormatException) {
            println("*** ERROR *** - Has introducido un id no numérico")
        }
    }


    private fun showBooks05() {
        library.showAllBooks()
    }


    fun appMenu() {
        var option = "hola"

        while (option != "6") {
            println("0. Iniciar libros y usuarios de ejemplo")
            println("1. Añadir libro")
            println("2. Añadir usuario")
            println("3. Prestar libro")
            println("4. Devolver libro")
            println("5. Mostrar libros")
            println("6. Salir")
            print("-> ")
            option = readln()
            performOption(option)
        }
    }


    private fun performOption(option: String) {
        when (option) {
            "0" -> initializeExampleLibrary00()
            "1" -> addBook01()
            "2" -> addUser02()
            "3" -> borrowBook03()
            "4" -> returnBook04()
            "5" -> showBooks05()
            "6" -> println("Cerrando aplicacion...")
            else -> println("La opcion no es valida\n")
        }
    }

}