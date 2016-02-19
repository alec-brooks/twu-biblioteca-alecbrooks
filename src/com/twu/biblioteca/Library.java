package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> bookList = new ArrayList<Book>();
    UserInterface ui;

    public Library(){
        bookList = generateNewBooklist();
    }

    public ArrayList<Book> generateNewBooklist(){
        Book b1984 = new Book("1984","George Orwell",1949);
        Book bLolita = new Book("Lolita","Vladmir Nabokov",1955);
        Book bOldPat = new Book("The Old Patagonian Express","Paul Theroux",1979);

        ArrayList<Book> bl = new ArrayList<Book>();

        bl.add(b1984);
        bl.add(bLolita);
        bl.add(bOldPat);

        return bl;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public void runUI(){
        ui = new UserInterface(bookList);
        System.out.println(ui.getWelcomeMessage());
        System.out.println(ui.getMenuString());

        int menuSelection = -1;

        while(menuSelection != ui.getExitCode()){
            menuSelection = ui.getUserMenuSelection();
            System.out.println(ui.getMenuOption(menuSelection));
        }
    }
}
