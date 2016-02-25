package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    ArrayList<BorrowableItem> bookList = new ArrayList<BorrowableItem>();
    ArrayList<BorrowableItem> movieList = new ArrayList<BorrowableItem>();
    UserInterface ui;

    public Library(){
        bookList = generateNewBookList();
        movieList = generateNewMovielist();
    }

    private ArrayList<BorrowableItem> generateNewMovielist(){
        Movie mNos = new Movie("Nosferatu","F.W. Murnau",1922, 8);
        Movie mSam = new Movie("Samurai Cop","Amir Shervan",1991, -1);
        Movie mPi = new Movie("Pi","Darren Aronofsky",1998, 7);


        ArrayList<BorrowableItem> ml = new ArrayList<BorrowableItem>();

        ml.add(mNos);
        ml.add(mSam);
        ml.add(mPi);

        return ml;
    }
    private ArrayList<BorrowableItem> generateNewBookList(){
        Book b1984 = new Book("1984","George Orwell",1949);
        Book bLolita = new Book("Lolita","Vladmir Nabokov",1955);
        Book bOldPat = new Book("The Old Patagonian Express","Paul Theroux",1979);

        ArrayList<BorrowableItem> bl = new ArrayList<BorrowableItem>();

        bl.add(b1984);
        bl.add(bLolita);
        bl.add(bOldPat);

        return bl;
    }

    public ArrayList<BorrowableItem> getBookList() {
        return bookList;
    }

    public ArrayList<BorrowableItem> getMovieList() {
        return movieList;
    }

    public void runUI(){
        ui = new UserInterface(bookList, movieList);
        System.out.println(ui.getWelcomeMessage());

        int menuSelection = -1;

        while(menuSelection != ui.getExitCode()){
            System.out.println(ui.getMenuString());
            menuSelection = ui.getUserMenuSelection();
            System.out.println(ui.getMenuOption(menuSelection));

            switch (menuSelection){
                case 2:
                    System.out.println(ui.checkOutMenuSelection(ui.getUserMenuSelection()));
                    break;
                case 3:
                    System.out.println(ui.returnMenuSelection(ui.getUserMenuSelection()));
                default:
                    break;
            }
        }
    }
}