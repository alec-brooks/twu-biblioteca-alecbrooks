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
        return getBookListString(false);
    }

    public String getBookListString(boolean numbered){
        String bookListString = "";
        int bookNumber = 1;
        if(!numbered) {
            bookListString = "Title                           Author                          Year\n";
        }
        for(Book b: bookList){
            if(numbered || !b.getCheckedOut()){
                if(numbered){
                    bookListString += bookNumber++ + ". ";
                }
                bookListString += b.getTitle();
                bookListString += generateNChars(TITLE_LIMIT - b.getTitle().length(), ' ');
                bookListString += DELIMITER;
                bookListString += b.getAuthor();
                bookListString += generateNChars(AUTHOR_LIMIT - b.getAuthor().length(), ' ');
                bookListString += DELIMITER;
                bookListString += b.getYearPublished();
                bookListString += "\n";
            }
        }
        bookListString += "\n";
        return bookListString;
    }

    public String getMenuString(){
        String menuString = "Choose from the following options and press enter:\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "0. Quit";
        return menuString;
    }

    public String getMenuOption(int selection){
        switch (selection){
            case 1:
                return getBookListString();
            case 2:
                return getCheckOutMenu();
            case 3:
                return getReturnMenu();
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
        String checkOutMenu= "Which book is being checked out? Make a selection.\n"+ getBookListString(true);

        return checkOutMenu;
    }

    public String getReturnMenu() {
        String returnMenu = "Which book is being returned? Make a selection.\n"+ getBookListString(true);

        return returnMenu;
    }

    public String checkOutMenuSelection(int selection) {
        String successMsg = "Thank you! Enjoy the book.";
        String failMsg = "That book is not available.";
        String menuType = "checkout";
        return secondaryMenuSelection(selection, successMsg, failMsg, menuType);
    }

    public String returnMenuSelection(int selection) {
        String successMsg = "Thank you for returning the book.";
        String failMsg = "That is not a valid book to return.";
        String menuType = "return";
        return secondaryMenuSelection(selection, successMsg, failMsg, menuType);
    }

    public String secondaryMenuSelection(int selection, String successMsg, String failMsg, String menuType){
        String msg;
        Boolean valid = selection > 0 && selection < bookList.size();
        Boolean success;
        if (valid) {
            if (menuType.equals("checkout")){
                success = bookList.get(selection - 1).checkOut();
            } else if (menuType.equals("return")){
                success = bookList.get(selection - 1).returnBook();
            } else{
                success = false;
            }
            if(success){
                msg =  successMsg;
            } else {
                msg = failMsg;
            }

        } else {
            msg = invalidMenuSelection();
        }

        return msg;
    }

    public String generateNChars(int n, char c){
        String s = "";
        for(int i = 0; i<n; i++){
            s += c;
        }
        return s;
    }
}
