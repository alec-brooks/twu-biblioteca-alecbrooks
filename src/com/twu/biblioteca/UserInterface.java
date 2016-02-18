package com.twu.biblioteca;

public class UserInterface {
    final String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";

    public String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    public String getBookList(){
        String bookList =   "1984                          | George Orwell                 | 1948\n"+
                            "Lolita                        | Vladmir Nabokov               | 1955\n"+
                            "The Old Patagonian Express    | Paul Theroux                  | 1979";
        return bookList;
    }

    public String getMenuString(){
        String menuString = "1. List Books";
        return menuString;
    }

    public String getMenuOption(int selection){
        return getBookList();
    }
}
