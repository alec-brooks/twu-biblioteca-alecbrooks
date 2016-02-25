package com.twu.biblioteca;

public class Movie extends BorrowableItem{
    public Movie(String title, String creator, int yearReleased, int rated){
        super(title, creator, yearReleased, rated);
    }
}
