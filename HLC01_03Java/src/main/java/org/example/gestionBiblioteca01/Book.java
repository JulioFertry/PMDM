package org.example.gestionBiblioteca01;

public class Book {
    private String name;
    private String author;
    private int bookId;
    private boolean borrowed;


    public Book(String name, String author, int bookId) {
        this.name = name;
        this.author = author;
        this.bookId = bookId;
        this.borrowed = false;
    }


    public int getBookId() {
        return bookId;
    }


    public boolean isBorrowed() {
        return borrowed;
    }


    public void borrow() {
        this.borrowed = true;
    }


    public void unborrow() {
        this.borrowed = false;
    }


    @Override
    public String toString() {
        String status = borrowed ? "No Disponible" : "Disponible";
        return "\nNombre: " + name + "\nAutor: " + author + "\n" + status;
    }
}
