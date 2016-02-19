package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    final String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";
    final int EXIT_CODE = 0;
    final int TITLE_LIMIT = 30;
    final int AUTHOR_LIMIT = 30;
    final String DELIMITER = "| ";
    ArrayList<Book> bookList;

    public UserInterface(ArrayList<Book> bl){
        bookList = bl;
    }

    public String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    public String getBookListString(){
        String bookListString = "Title                           Author                          Year\n";
        for(Book b: bookList){
            bookListString += b.getTitle();
            bookListString += generateNChars(TITLE_LIMIT-b.getTitle().length(), ' ');
            bookListString += DELIMITER;
            bookListString += b.getAuthor();
            bookListString += generateNChars(AUTHOR_LIMIT-b.getAuthor().length(), ' ');
            bookListString += DELIMITER;
            bookListString += b.getYearPublished();
            bookListString += "\n";
        }
        bookListString += "\n";
        return bookListString;
    }

    public String getMenuString(){
        String menuString = "Choose from the following options and press enter:\n1. List Books\n0. Quit";
        return menuString;
    }

    public String getMenuOption(int selection){
        switch (selection){
            case 1:
                return getBookListString() + getMenuString();
            case 2:
                return getCheckOutMenu();
            case 0:
                return "";
            default:
                return invalidMenuSelection();
        }
    }

    public int getUserMenuSelection(){
        int selection;
        Scanner input = new Scanner(System.in);

        //If improper value entered, return numerical invalid input
        try {
            selection = input.nextInt();
        } catch (Exception e){
            selection = -1;
        }
        return selection;
    }

    public int getExitCode(){
        return EXIT_CODE;
    }

    public String invalidMenuSelection(){
        return "Select a valid option!";
    }

    public String getCheckOutMenu() {
        String checkOutMenu= "Which book is being checked out? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";
        return checkOutMenu;
    }

    public String generateNChars(int n, char c){
        String s = "";
        for(int i = 0; i<n; i++){
            s += c;
        }
        return s;
    }
}
