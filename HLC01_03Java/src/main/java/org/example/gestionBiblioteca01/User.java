package org.example.gestionBiblioteca01;

public class User {
    private String userName;
    private int userId;
    private Book currentBook;

    // Constructor
    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
        this.currentBook = null;
    }


    public void receiveBook(Book book) {
        this.currentBook = book;
    }


    public void giveBookBack() {
        this.currentBook = null;
    }


    public boolean hasBook() {
        return currentBook != null;
    }


    public Book getBook() {
        return currentBook;
    }


    public int getUserId() {
        return userId;
    }


    public String getUserName() {
        return userName;
    }

}
