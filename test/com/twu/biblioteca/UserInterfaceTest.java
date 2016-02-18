package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    String bookList =   "Title                           Author                          Year\n"+
                        "1984                          | George Orwell                 | 1949\n"+
                        "Lolita                        | Vladmir Nabokov               | 1955\n"+
                        "The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";

    String menuString = "Choose from the following options and press enter:\n1. List Books\n0. Quit";

    UserInterface ui = new UserInterface();

    @Test
    public void testGetWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca, an interactive Library Management System";
        assertEquals(welcomeMessage, ui.getWelcomeMessage());
    }

    @Test
    public void testGetBookList(){
        assertEquals(bookList, ui.getBookList());
    }

    @Test
    public void testGetMainMenu(){
        assertEquals(menuString, ui.getMenuString());
    }

    @Test
    public void testListBooksSelection(){
        assertEquals(bookList+menuString, ui.getMenuOption(1));
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
    public void testInitialCheckoutMenu(){
        String checkoutMenu = "Which book is being checked out? Make a selection.\n"+
                "1. 1984                          | George Orwell                 | 1949\n" +
                "2. Lolita                        | Vladmir Nabokov               | 1955\n" +
                "3. The Old Patagonian Express    | Paul Theroux                  | 1979\n\n";
        assertEquals(checkoutMenu, ui.getMenuOption(2));
    }
}
