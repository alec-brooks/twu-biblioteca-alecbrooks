package com.twu.biblioteca;

import java.util.Scanner;

public class UserInterface {
    final String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";
    final int EXIT_CODE = 0;

    public String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    public String getBookList(){
        String bookList =   "Title                           Author                          Year\n"+
                            "1984                          | George Orwell                 | 1949\n"+
                            "Lolita                        | Vladmir Nabokov               | 1955\n"+
                            "The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";
        return bookList;
    }

    public String getMenuString(){
        String menuString = "Choose from the following options and press enter:\n1. List Books\n0. Quit";
        return menuString;
    }

    public String getMenuOption(int selection){
        switch (selection){
            case 1:
                return getBookList() + getMenuString();
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
        return ;
    }
}
