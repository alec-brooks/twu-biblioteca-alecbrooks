package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {

    @Test
    public void testWelcomeMessage() {
        String welcomeMessage = "Welcome to Biblioteca, an interactive Library Management System";
        assertEquals(welcomeMessage, new UserInterface().getWelcomeMessage());
    }

    @Test
    public void testBookList(){
        String bookList = "1984\nLolita\nThe Old Patagonian Express";
        assertEquals(bookList, new UserInterface().getBookList());
    }
}
