package org.example.gestionBiblioteca01;

import java.util.Scanner;

public class LibraryOperations {
    private Library library;


    public LibraryOperations() {
        library = new Library();
    }


    private void initializeExampleLibrary00() {
        library.getBooks().add(new Book("El lazarillo de tormes", null, 1));
        library.getBooks().add(new Book("1984", "George Orwell", 2));
        library.getBooks().add(new Book("Alice in Wonderland", "Lewis Carroll", 3));
        library.getBooks().add(new Book("The Lord of the Rings", "J.R.R Tolkien", 4));
        library.getBooks().add(new Book("Divina Commedia", "Dante Alighieri", 5));

        library.getUsers().add(new User("Pepe", 1));
        library.getUsers().add(new User("Juan", 2));
        library.getUsers().add(new User("Eustaquio", 3));
    }


    private void addBook01() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del libro: ");
        String name = scanner.nextLine();

        System.out.print("Introduce el nombre del autor: ");
        String author = scanner.nextLine();

        library.addBook(name, author);
    }


    private void addUser02() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del usuario: ");
        String name = scanner.nextLine();

        library.registerUser(name);
    }


    private void borrowBook03() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce el id del libro: ");
            int bookId = Integer.parseInt(scanner.nextLine());

            System.out.print("Introduce el id del usuario: ");
            int userId = Integer.parseInt(scanner.nextLine());

            library.borrowBook(bookId, userId);
        } catch (NumberFormatException e) {
            System.out.println("*** ERROR *** - Has introducido un id no numérico");
        }
    }


    private void returnBook04() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce el id del usuario: ");
            int userId = Integer.parseInt(scanner.nextLine());

            library.returnBook(userId);
        } catch (NumberFormatException e) {
            System.out.println("*** ERROR *** - Has introducido un id no numérico");
        }
    }


    private void showBooks05() {
        library.showAllBooks();
    }


    public void appMenu() {
        Scanner scanner = new Scanner(System.in);
        String option = "hola";

        while (!option.equals("6")) {
            System.out.println("0. Iniciar libros y usuarios de ejemplo");
            System.out.println("1. Añadir libro");
            System.out.println("2. Añadir usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Mostrar libros");
            System.out.println("6. Salir");
            System.out.print("-> ");
            option = scanner.nextLine();

            try {
                performOption(option);
            } catch (Exception e) {
                System.out.println("ERROR (" + e + ")");
            }
        }
    }


    private void performOption(String option) {
        switch (option) {
            case "0":
                initializeExampleLibrary00();
                break;
            case "1":
                addBook01();
                break;
            case "2":
                addUser02();
                break;
            case "3":
                borrowBook03();
                break;
            case "4":
                returnBook04();
                break;
            case "5":
                showBooks05();
                break;
            case "6":
                System.out.println("Cerrando aplicación...");
                break;
            default:
                System.out.println("La opción no es válida\n");
        }
    }
}
