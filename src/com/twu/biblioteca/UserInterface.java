package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    final String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";
    final int EXIT_CODE = 0;
    final int TITLE_LIMIT = 30;
    final int CREATOR_LIMIT = 30;
    final String DELIMITER = "| ";
    ArrayList<BorrowableItem> bookList;
    ArrayList<BorrowableItem> movieList;

    public UserInterface(ArrayList<BorrowableItem> bookList, ArrayList<BorrowableItem> movieList){
        this.bookList = bookList;
        this.movieList = movieList;
    }

    public String getWelcomeMessage(){
        return WELCOME_MESSAGE;
    }

    public String getBookListString(){
        return getBookListString(false);
    }

    private String getBookListString(boolean numbered) {
        return getBorrowableItemListString("book", numbered);
    }

    private String getMovieListString(boolean numbered) {
        return getBorrowableItemListString("movie", numbered);
    }

    public String getMovieListString(){
        return getMovieListString(false);
    }

    private String getBorrowableItemListString(String borrowableItemType, boolean numbered){
        String listString = "";
        int itemNumber = 1;
        String heading = "";
        ArrayList<BorrowableItem> itemList = new ArrayList<BorrowableItem>();

        if(borrowableItemType.equals("book")) {
            heading = "Title                           Author                          Year\n";
            itemList = bookList;
        } else if (borrowableItemType.equals("movie")) {
            heading  ="Title                           Director                        Year  Rating\n";
            itemList = movieList;
        }

        if(!numbered) {
            listString += heading;
        }
        for(BorrowableItem b: itemList){
            if(numbered || !b.getCheckedOut()){
                if(numbered){
                    listString += itemNumber++ + ". ";
                }
                listString += b.getTitle();
                listString += generateNChars(TITLE_LIMIT - b.getTitle().length(), ' ');
                listString += DELIMITER;
                listString += b.getCreator();
                listString += generateNChars(CREATOR_LIMIT - b.getCreator().length(), ' ');
                listString += DELIMITER;
                listString += b.getYearReleased();
                if(borrowableItemType.equals("movie")){
                    listString += DELIMITER;
                    if(b.getRating() > 0) {
                        listString += b.getRating();
                    } else {
                        listString += "unrated";
                    }
                }
                listString += "\n";

            }
        }
        return listString;
    }

    public String getMenuString(){
        String menuString = "Choose from the following options and press enter:\n" +
                "1. List Books\n" +
                "2. Checkout Book\n" +
                "3. Return Book\n" +
                "4. List Movies\n" +
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
            case 4:
                return getMovieListString();
            case 5:
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

    private String invalidMenuSelection(){
        return "Select a valid option!";
    }

    private String getCheckOutMenu() {
        String checkOutMenu= "Which book is being checked out? Make a selection.\n"+ getBookListString(true);

        return checkOutMenu;
    }

    private String getReturnMenu() {
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

    private String secondaryMenuSelection(int selection, String successMsg, String failMsg, String menuType){
        String msg;
        Boolean valid = selection > 0 && selection <= bookList.size();
        Boolean success;
        if (valid) {
            if (menuType.equals("checkout")){
                success = bookList.get(selection - 1).checkOut();
            } else if (menuType.equals("return")){
                success = bookList.get(selection - 1).returnBorrowableItem();
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

    private String generateNChars(int n, char c){
        String s = "";
        for(int i = 0; i<n; i++){
            s += c;
        }
        return s;
    }
}
