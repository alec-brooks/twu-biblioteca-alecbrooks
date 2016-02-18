package com.twu.biblioteca;

public class Book {
    String title;
    String author;
    int yearPublished;
    Boolean checkedOut;

    public Book(String title, String author, int yearPublished){
        title = title;
        author = author;
        yearPublished = yearPublished;
        checkedOut = false;
    }

    public void checkOut(){
        checkedOut = true;
    }
}
