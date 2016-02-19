package com.twu.biblioteca;

public class Book {
    String title;
    String author;
    int yearPublished;
    Boolean checkedOut;

    public Book(String bookTitle, String bookAuthor, int bookYearPublished){
        title = bookTitle;
        author = bookAuthor;
        yearPublished = bookYearPublished;
        checkedOut = false;
    }

    public Boolean checkOut(){
        Boolean success;

        success = !checkedOut;

        if(success){
            checkedOut = true;
        }

        return success;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public Boolean returnBook(){
        Boolean success;

        success = checkedOut;

        if(success){
            checkedOut = false;
        }

        return success;
    }
}
