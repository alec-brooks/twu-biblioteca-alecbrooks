package com.twu.biblioteca;

public class UserInterface {
    final String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";

    public String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    public String getBookList(){
        String bookList = "1984\nLolita\nThe Old Patagonian Express";
        return bookList;
    }
}
