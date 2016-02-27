package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    String bookListString = "Title                           Author                          Year\n"+
                            "1984                          | George Orwell                 | 1949\n"+
                            "Lolita                        | Vladmir Nabokov               | 1955\n"+
                            "The Old Patagonian Express    | Paul Theroux                  | 1979\n";

    String movieListString ="Title                           Director                        Year  Rating\n"+
                            "Nosferatu                     | F.W. Murnau                   | 1922| 8\n"+
                            "Samurai Cop                   | Amir Shervan                  | 1991| unrated\n"+
                            "Pi                            | Darren Aronofsky              | 1998| 7\n";


    String bookListStringWithout1984 =   "Title                           Author                          Year\n"+
            "Lolita                        | Vladmir Nabokov               | 1955\n"+
            "The Old Patagonian Express    | Paul Theroux                  | 1979\n";

    String menuString = "Choose from the following options and press enter:\n" +
            "1. List Books\n" +
            "2. Checkout Book\n" +
            "3. Return Book\n" +
            "4. List Movies\n" +
            "5. Checkout Movie\n" +
            "6. Return Movie\n" +
            "7. View Contact Information\n" +
            "0. Quit";

    User user = new User("123-4567", "abc", "a@b.com\n0411111111");
    ArrayList<BorrowableItem> bl = new Library().getBookList();
    ArrayList<BorrowableItem> ml = new Library().getMovieList();
    UserInterface ui = new UserInterface(bl, ml);

    @Test
    public void testGetWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca, an interactive Library Management System";
        assertEquals(welcomeMessage, ui.getWelcomeMessage());
    }

    @Test
    public void testGetBookList(){
        assertEquals(bookListString , ui.getBookListString());
    }

    @Test
    public void testGetMainMenu(){
        assertEquals(menuString, ui.getMenuString());
    }

    @Test
    public void testListBooksSelection(){
        assertEquals(bookListString, ui.getMenuOption(1, user));
    }

    @Test
    public void testInvalidMenuSelection(){
        assertEquals("Select a valid option!", ui.getMenuOption(9, user));
    }

    @Test
    public void testQuitMessage(){
        assertEquals("", ui.getMenuOption(0, user));
    }

    @Test
    public void testListBooksAfterCheckout(){
        ArrayList<BorrowableItem> blWithCheckout = bl;
        blWithCheckout.get(0).checkOut();
        UserInterface uiWithCheckout = new UserInterface(blWithCheckout, ml);
        assertEquals(bookListStringWithout1984, uiWithCheckout.getMenuOption(1, user));
    }
    @Test
    public void testInitialBookCheckoutMenu(){
        String checkoutMenu = "Which book is being checked out? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n";
        assertEquals(checkoutMenu, ui.getMenuOption(2, user));
    }

    @Test
    public void testCheckoutSuccessMessage(){
        assertEquals(ui.checkOutBookMenuSelection(1, user), "Thank you! Enjoy the book.");
    }

    @Test
    public void testCheckoutFailureMessage(){
        ArrayList<BorrowableItem> blWithCheckout = bl;
        blWithCheckout.get(0).checkOut();
        UserInterface uiWithCheckout = new UserInterface(blWithCheckout, ml);
        assertEquals(uiWithCheckout.checkOutBookMenuSelection(1, user), "That book is not available.");
    }

    @Test
    public void testInitialReturnMenu(){
        String checkoutMenu = "Which book is being returned? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n";
        assertEquals(checkoutMenu, ui.getMenuOption(3, user));
    }

    @Test
    public void testReturnSuccessMessage(){
        ArrayList<BorrowableItem> blWithCheckout = bl;
        blWithCheckout.get(0).checkOut();
        UserInterface uiWithCheckout = new UserInterface(blWithCheckout, ml);
        assertEquals(uiWithCheckout.returnBookMenuSelection(1, user), "Thank you for returning the book.");
    }

    @Test
    public void testReturnFailureMenu(){
        assertEquals(ui.returnBookMenuSelection(1, user), "That is not a valid book to return.");
    }

    @Test
    public void testGetMovieList(){
        assertEquals(movieListString, ui.getMovieListString());
    }

    @Test
    public void testInitialMovieCheckoutList(){
        String menu = "Which movie is being checked out? Make a selection.\n" +
                "1. Nosferatu                     | F.W. Murnau                   | 1922| 8\n"+
                "2. Samurai Cop                   | Amir Shervan                  | 1991| unrated\n"+
                "3. Pi                            | Darren Aronofsky              | 1998| 7\n";

        assertEquals(menu, ui.getMenuOption(5, user));
    }

    @Test
    public void testGetUserInformation(){
        assertEquals("a@b.com\n0411111111", ui.getMenuOption(7, user));
    }

}
