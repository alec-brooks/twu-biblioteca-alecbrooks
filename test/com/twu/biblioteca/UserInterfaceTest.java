package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    String bookListString =   "Title                           Author                          Year\n"+
                        "1984                          | George Orwell                 | 1949\n"+
                        "Lolita                        | Vladmir Nabokov               | 1955\n"+
                        "The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";

    String bookListStringWithout1984 =   "Title                           Author                          Year\n"+
            "Lolita                        | Vladmir Nabokov               | 1955\n"+
            "The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";

    String menuString = "Choose from the following options and press enter:\n" +
            "1. List Books\n" +
            "2. Checkout Book\n" +
            "3. Return Book\n" +
            "0. Quit";

    ArrayList<Book> bl = new Library().getBookList();
    UserInterface ui = new UserInterface(bl);

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
        assertEquals(bookListString, ui.getMenuOption(1));
    }

    @Test
    public void testInvalidMenuSelection(){
        assertEquals("Select a valid option!", ui.getMenuOption(9));
    }

    @Test
    public void testQuitMessage(){
        assertEquals("", ui.getMenuOption(0));
    }

    @Test
    public void testListBooksAfterCheckout(){
        ArrayList<Book> blWithCheckout = bl;
        blWithCheckout.get(0).checkOut();
        UserInterface uiWithCheckout = new UserInterface(blWithCheckout);
        assertEquals(bookListStringWithout1984, uiWithCheckout.getMenuOption(1));
    }
    @Test
    public void testInitialCheckoutMenu(){
        String checkoutMenu = "Which book is being checked out? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";
        assertEquals(checkoutMenu, ui.getMenuOption(2));
    }

    @Test
    public void testCheckoutSuccessMessage(){
        assertEquals(ui.checkOutMenuSelection(1), "Thank you! Enjoy the book.");
    }

    @Test
    public void testCheckoutFailureMessage(){
        ArrayList<Book> blWithCheckout = bl;
        blWithCheckout.get(0).checkOut();
        UserInterface uiWithCheckout = new UserInterface(blWithCheckout);
        assertEquals(uiWithCheckout.checkOutMenuSelection(1), "That book is not available.");
    }

    @Test
    public void testInitialReturnMenu(){
        String checkoutMenu = "Which book is being returned? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";
        assertEquals(checkoutMenu, ui.getMenuOption(3));
    }
}
