package org.example.gestionBiblioteca01;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;


    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }


    public List<Book> getBooks() {
        return books;
    }


    public List<User> getUsers() {
        return users;
    }


    public void addBook(String name, String author) {
        int id = (books.isEmpty()) ? 0 : books.get(books.size() - 1).getBookId() + 1;
        Book newBook = new Book(name, author, id);
        books.add(newBook);
    }


    public void registerUser(String name) {
        int id = (users.isEmpty()) ? 0 : users.get(users.size() - 1).getUserId() + 1;
        User newUser = new User(name, id);
        users.add(newUser);
    }


    public void borrowBook(int bookId, int userId) {
        try {
            Book book = findBookById(bookId);
            if (book == null) {
                throw new Exception("No existe el libro");
            }

            User user = findUserById(userId);
            if (user == null) {
                throw new Exception("No existe el usuario");
            }

            if (book.isBorrowed()) {
                System.out.println("El libro ya está prestado");
            } else if (user.hasBook()) {
                System.out.println("El usuario ya tiene un libro");
            } else {
                user.receiveBook(book);
                book.borrow();
            }
        } catch (Exception e) {
            System.out.println("*** ERROR *** (" + e.getMessage() + ")");
        }
    }


    public void returnBook(int userId) {
        try {
            User user = findUserById(userId);
            if (user == null) {
                throw new Exception("No existe el usuario");
            }

            Book book = user.getBook();
            if (book != null) {
                book.unborrow();
                user.giveBookBack();
            } else {
                System.out.println("Este usuario no tiene ningún libro");
            }
        } catch (Exception e) {
            System.out.println("*** ERROR *** - (" + e.getMessage() + ")");
        }
    }


    public void showAllBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
