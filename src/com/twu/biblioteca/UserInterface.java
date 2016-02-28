package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    final static String WELCOME_MESSAGE = "Welcome to Biblioteca, an interactive Library Management System";
    final static int EXIT_CODE = 0;
    final static int TITLE_LIMIT = 30;
    final static int CREATOR_LIMIT = 30;
    final static String DELIMITER = "| ";
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
                "5. Checkout Movie\n" +
                "6. Return Movie\n" +
                "7. View Contact Information\n" +
                "0. Quit";
        return menuString;
    }

    public String getMenuOption(int selection, User user){
        switch (selection){
            case 1:
                return getBookListString();
            case 2:
                return getBookCheckOutMenu();
            case 3:
                return getBookReturnMenu();
            case 4:
                return getMovieListString();
            case 5:
                return getMovieCheckOutMenu();
            case 6:
                return getMovieReturnMenu();
            case 7:
                return user.getContactInformation();
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

    public String checkOutBookMenuSelection(int selection, User user) {
        String menuType = "checkout";
        String menuItemType = "book";
        return secondaryMenuSelection(selection, menuType, menuItemType, user);
    }

    public String returnBookMenuSelection(int selection, User user) {
        String menuType = "return";
        String menuItemType = "book";
        return secondaryMenuSelection(selection, menuType, menuItemType, user);
    }

    public String checkOutMovieMenuSelection(int selection, User user) {
        String menuType = "checkout";
        String menuItemType = "movie";
        return secondaryMenuSelection(selection, menuType, menuItemType, user);
    }

    public String returnMovieMenuSelection(int selection, User user) {
        String menuType = "return";
        String menuItemType = "movie";
        return secondaryMenuSelection(selection, menuType, menuItemType, user);
    }

    private String invalidMenuSelection(){
        return "Select a valid option!";
    }

    private String getBookCheckOutMenu(){
        return getSecondaryMenu("book", "checked out");
    }

    private String getMovieCheckOutMenu(){
        return getSecondaryMenu("movie", "checked out");
    }

    private String getBookReturnMenu() {
        return getSecondaryMenu("book", "returned");
    }

    private String getMovieReturnMenu() {
        return getSecondaryMenu("movie", "returned");
    }

    private String getSecondaryMenu(String menuItemType, String pastVerb) {
        String listString = "";

        if(menuItemType.equals("book")) {
            listString = getBookListString(true);
        } else if (menuItemType.equals("movie")){
            listString = getMovieListString(true);
        }

        String secondaryMenu = "Which "+menuItemType+" is being "+pastVerb+"? Make a selection.\n"+ listString;

        return secondaryMenu;
    }

    private String getSecondaryMenuSuccessMsg(String menuType, String menuItemType){
        String msg = "";
        if(menuType.equals("return")){
            msg = "Thank you for returning the "+menuItemType+".";
        } else if (menuType.equals("checkout")){
            msg = "Thank you! Enjoy the "+menuItemType+".";
        }
        return msg;
    }

    private String getSecondaryMenuFailMsg(String menuType, String menuItemType){
        String msg = "";
        if(menuType.equals("return")){
            msg = "That is not a valid "+menuItemType+" to return.";
        } else if (menuType.equals("checkout")){
            msg = "That "+menuItemType+" is not available.";
        }
        return msg;
    }

    private ArrayList<BorrowableItem> getSecondaryMenuItemList(String menuItemType){
        ArrayList<BorrowableItem> itemList = new ArrayList<BorrowableItem>();

        if(menuItemType.equals("book")){
            itemList = bookList;
        } else if (menuItemType.equals("movie")){
            itemList = movieList;
        }

        return itemList;
    }

    private String secondaryMenuSelection(int selection, String menuType, String menuItemType, User user){
        String msg;
        String successMsg;
        String failMsg;

        ArrayList<BorrowableItem> itemList;

        itemList = getSecondaryMenuItemList(menuItemType);

        msg = determineSecondaryMenuMsg(itemList, menuType, menuItemType, selection, user);

        return msg;
    }

    private String determineSecondaryMenuMsg(ArrayList<BorrowableItem> itemList, String menuType, String menuItemType, int selection, User user){
        String msg;

        if (isValidSelection(selection, itemList)) {
            if(isSuccessfulTransaction(selection, itemList, menuType)){
                msg =  getSecondaryMenuSuccessMsg(menuType, menuItemType);
                if(menuType.equals("checkout")){
                    user.addCheckout(itemList.get(selection-1));
                } else {
                    user.removeCheckoutByTitle(itemList.get(selection-1).getTitle());
                }
            } else {
                msg = getSecondaryMenuFailMsg(menuType, menuItemType);
            }

        } else {
            msg = invalidMenuSelection();
        }

        return msg;
    }

    private Boolean isValidSelection(int selection, ArrayList<BorrowableItem> itemList){
        return selection > 0 && selection <= itemList.size();
    }

    private Boolean isSuccessfulTransaction(int selection, ArrayList<BorrowableItem> itemList, String menuType){
        Boolean success;
        if (menuType.equals("checkout")){
            success = itemList.get(selection - 1).checkOut();
        } else if (menuType.equals("return")){
            success = itemList.get(selection - 1).returnBorrowableItem();
        } else{
            success = false;
        }
        return  success;
    }

    private String generateNChars(int n, char c){
        String s = "";
        for(int i = 0; i<n; i++){
            s += c;
        }
        return s;
    }
}
