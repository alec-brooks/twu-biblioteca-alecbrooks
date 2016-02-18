package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    String bookList =   "1984                          | George Orwell                 | 1948\n"+
                        "Lolita                        | Vladmir Nabokov               | 1955\n"+
                        "The Old Patagonian Express    | Paul Theroux                  | 1979";

    @Test
    public void testGetWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca, an interactive Library Management System";
        assertEquals(welcomeMessage, new UserInterface().getWelcomeMessage());
    }

    @Test
    public void testGetBookList(){
        assertEquals(bookList, new UserInterface().getBookList());
    }

    @Test
    public void testGetMainMenu(){
        String menuString = "1. List Books";
        assertEquals(menuString, new UserInterface().getMenuString());
    }

    @Test
    public void testListBookSelection(){
        UserInterface ui = new UserInterface();
        assertEquals(bookList, ui.getMenuOption(1));
    }

}
