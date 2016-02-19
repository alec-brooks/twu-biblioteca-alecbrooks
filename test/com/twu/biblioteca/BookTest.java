package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

public class BookTest {

    public ArrayList<Book> getBookList(){
        Book b1984 = new Book("1984","George Orwell",1949);
        Book bLolita = new Book("Lolita","Vladmir Nabokov",1955);
        Book bOldPat = new Book("The Grand Patagonian Express","Paul Theroux",1979);

        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(b1984);
        bookList.add(bLolita);
        bookList.add(bOldPat);

        return bookList;
    }

    @Test
    public void testBooksAvailableAtStart(){
        ArrayList<Book> bl = getBookList();
        assertFalse(bl.get(0).checkedOut);
    }

    @Test
    public void testBookCheckout(){
        ArrayList<Book> bl = getBookList();
        bl.get(0).checkOut();
        assertTrue(bl.get(0).checkedOut);
    }

    @Test
    public void testTitle(){
        ArrayList<Book> bl = getBookList();
        assertEquals(bl.get(0).getTitle(), "1984");
    }
}
