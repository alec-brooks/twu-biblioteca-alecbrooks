package com.twu.biblioteca;

public class Book extends BorrowableItem{
    public Book(String title, String creator, int yearReleased){
        super(title, creator, yearReleased, -1);
    }
}
